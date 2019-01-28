package io.github.cadiboo;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.tools.agent.MixinAgent;

/**
 * @author Cadiboo
 */
public class FFS {

	static {
		MixinAgent.agentmain(null, null);
	}

}
