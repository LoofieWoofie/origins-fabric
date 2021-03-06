package io.github.apace100.origins.power;

import io.github.apace100.origins.util.HudRender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

import java.util.function.Consumer;

public class ActiveCooldownPower extends CooldownPower implements Active {

    private final Consumer<Entity> activeFunction;

    public ActiveCooldownPower(PowerType<?> type, PlayerEntity player, int cooldownDuration, HudRender hudRender, Consumer<Entity> activeFunction) {
        super(type, player, cooldownDuration, hudRender);
        this.activeFunction = activeFunction;
    }

    @Override
    public void onUse() {
        if(canUse()) {
            this.activeFunction.accept(this.player);
            use();
        }
    }

    private KeyType keyType;

    @Override
    public KeyType getKey() {
        return keyType;
    }

    @Override
    public void setKey(KeyType type) {
        keyType = type;
    }
}
