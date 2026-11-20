package pl.polesmierci;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class PoleSmierci implements ModInitializer {
    private static final Style PLAIN = Style.EMPTY.withItalic(false);

    private static MutableText t(String s, Formatting c) {
        return Text.literal(s).setStyle(PLAIN.withColor(c));
    }

    private static MutableText line(MutableText... parts) {
        MutableText out = t("✖ ", Formatting.DARK_GRAY);
        for (MutableText p : parts) out.append(p);
        return out;
    }

    @Override
    public void onInitialize() {
        // tytul to obrazek wyciety ze screena (znak  w czcionce moda)
        Text name = Text.literal("").setStyle(PLAIN.withColor(Formatting.WHITE));

        LoreComponent lore = new LoreComponent(List.of(
                line(t("W obrębie ", Formatting.WHITE), t("5 kratek", Formatting.GREEN), t(" dookoła zabieramy", Formatting.WHITE)),
                line(t("każdemu możliwość używania ", Formatting.WHITE), t("elytry", Formatting.GRAY), t(" na kilka sekund", Formatting.WHITE)),
                line(t("oraz tworzymy ", Formatting.WHITE), t("strefy z laserami", Formatting.GOLD), t(", które", Formatting.WHITE)),
                line(t("zadają ", Formatting.WHITE), t("obrażenia", Formatting.RED), t(" każdemu kto stanie im na drodze", Formatting.WHITE)),
                Text.empty(),
                t("Kliknij ", Formatting.GREEN)
                        .append(Text.literal("").setStyle(PLAIN.withColor(Formatting.WHITE)))
                        .append(t(" aby użyć", Formatting.GREEN))
        ));

        Identifier style = Identifier.of("minecraft", "pole_smierci");

        DefaultItemComponentEvents.MODIFY.register(ctx -> {
            for (Item item : new Item[]{Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE}) {
                ctx.modify(item, b -> {
                    b.add(DataComponentTypes.ITEM_NAME, name);
                    b.add(DataComponentTypes.LORE, lore);
                    b.add(DataComponentTypes.TOOLTIP_STYLE, style);
                });
            }
        });
    }
}
