package moriyashiine.crashma.common.integration.botania;

import moriyashiine.crashma.client.integration.botania.packet.CrashmaLensPacket;
import moriyashiine.crashma.common.Crashma;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.common.core.BotaniaCreativeTab;
import vazkii.botania.common.item.lens.ItemLens;
import vazkii.botania.common.item.lens.Lens;

import java.util.List;

public class ModBotaniaIntegration {
	public static final ItemLens MANA_LENS_CRASH = new ItemLens(new FabricItemSettings().group(BotaniaCreativeTab.INSTANCE).maxCount(16), new Lens() {
		@Override
		public void updateBurst(IManaBurst burst, ItemStack stack) {
			ThrowableProjectile entity = burst.entity();
			if (entity.level.isClientSide()) {
				return;
			}
			AABB axis = new AABB(entity.getX(), entity.getY(), entity.getZ(), entity.xOld, entity.yOld, entity.zOld).inflate(1);
			List<LivingEntity> entities = entity.level.getEntitiesOfClass(LivingEntity.class, axis);
			for (LivingEntity living : entities) {
				Entity owner = burst.entity().getOwner();
				if (owner != null && living.getUUID().equals(owner.getUUID())) {
					continue;
				}
				int mana = burst.getMana();
				if (mana >= 16) {
					burst.setMana(mana - 16);
					if (!burst.isFake()) {
						if (living instanceof ServerPlayer serverPlayer) {
							CrashmaLensPacket.send(serverPlayer);
						} else {
							living.remove(Entity.RemovalReason.DISCARDED);
						}
					}
					break;
				}
			}
		}
	}, ItemLens.PROP_DAMAGE);

	public static void init() {
		Registry.register(Registry.ITEM, new ResourceLocation(Crashma.MOD_ID, "mana_lens_crash"), MANA_LENS_CRASH);
	}
}
