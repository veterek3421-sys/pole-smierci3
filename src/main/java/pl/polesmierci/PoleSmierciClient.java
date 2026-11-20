package pl.polesmierci;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;

public class PoleSmierciClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            if (!stack.isOf(Items.GOLDEN_APPLE) && !stack.isOf(Items.ENCHANTED_GOLDEN_APPLE)) return;
            String id = Registries.ITEM.getId(stack.getItem()).toString();
            // usuwa "minecraft:golden_apple" i "N component(s)" z F3+H
            lines.removeIf((Text l) -> l.getString().equals(id)
                    || (l.getContent() instanceof TranslatableTextContent t && t.getKey().equals("item.components")));
        });
    }
}
