package umasimulator.model.supportcard;

import java.util.EnumMap;
import java.util.List;

public class ActiveSupportCard {
    private final SupportCard supportCard;
    private final int level;
    private final EnumMap <Modifier, Double> effectModifiers;

    public ActiveSupportCard(SupportCard supportCard, int level) {
        this.supportCard = supportCard;
        this.level = level;
        this.effectModifiers = new EnumMap<>(Modifier.class);
    }

    public EnumMap<Modifier, Double> getEffectModifiers() {
        return effectModifiers;
    }

    public void calculateEffectModifiers() {
        List<LevelEffects> effectsList = supportCard.levelEffectsList();
        effectModifiers.clear();
        for (int i = 0; i < effectsList.size(); i++) {

            LevelEffects effect = effectsList.get(i);
            Modifier modifier = effect.modifier();
            List<LevelScaling> levelScaling = effect.levelScaling();

            //fallback incase there is no scaling for the level
            effectModifiers.put(modifier, 0.0); 

            //checks for the level the modifier will have according to scaling and the card level
            search:
            for (int j = level; j >= 0; j--) {
                for (int k = 0; k < levelScaling.size(); k++) {
                    LevelScaling scaling = levelScaling.get(k);
                    if (scaling.level() == j) {
                        effectModifiers.put(modifier, scaling.value());
                        break search;
                    }
                }
            }
        }
    }
}
