package io.github.cadiboo.iblockstateshouldsideberenderedhook.mod;

import io.github.cadiboo.renderchunkrebuildchunkhooks.event.RebuildChunkBlockEvent;
import io.github.cadiboo.renderchunkrebuildchunkhooks.event.RebuildChunkBlockRenderInLayerEvent;
import io.github.cadiboo.renderchunkrebuildchunkhooks.event.RebuildChunkBlockRenderTypeAllowsRenderEvent;
import io.github.cadiboo.renderchunkrebuildchunkhooks.event.RebuildChunkPostEvent;
import io.github.cadiboo.renderchunkrebuildchunkhooks.event.RebuildChunkPreEvent;
import io.github.cadiboo.renderchunkrebuildchunkhooks.hooks.RenderChunkRebuildChunkHooksHooks;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.ReportedException;
import net.minecraftforge.fml.common.Loader;

import static io.github.cadiboo.renderchunkrebuildchunkhooks.mod.RenderChunkRebuildChunkHooksDummyModContainer.MOD_LOGGER;

/**
 * @author Cadiboo
 */
public final class ModUtil {

	static void preloadEvents() {
		MOD_LOGGER.info("Pre-loading event classes...");
		RebuildChunkPreEvent.class.getName();
		RebuildChunkBlockRenderInLayerEvent.class.getName();
		RebuildChunkBlockRenderTypeAllowsRenderEvent.class.getName();
		RebuildChunkBlockEvent.class.getName();
		RebuildChunkPostEvent.class.getName();
		MOD_LOGGER.info("Loaded event classes, initialising...");
		try {
			Class.forName(RebuildChunkPreEvent.class.getName(), true, Loader.instance().getModClassLoader());
			Class.forName(RebuildChunkBlockRenderInLayerEvent.class.getName(), true, Loader.instance().getModClassLoader());
			Class.forName(RebuildChunkBlockRenderTypeAllowsRenderEvent.class.getName(), true, Loader.instance().getModClassLoader());
			Class.forName(RebuildChunkBlockEvent.class.getName(), true, Loader.instance().getModClassLoader());
			Class.forName(RebuildChunkPostEvent.class.getName(), true, Loader.instance().getModClassLoader());
		} catch (ClassNotFoundException e) {
			final CrashReport crashReport = new CrashReport("Error initialising event classes!", e);
			crashReport.makeCategory("Reflectively accessing event classes");
			throw new ReportedException(crashReport);
		}
		MOD_LOGGER.info("Successfully Pre-loaded event classes");
	}

	static void preloadRenderChunk() {
		MOD_LOGGER.info("Pre-loading RenderChunk...");
		try {
			RenderChunk.class.getName();
			MOD_LOGGER.info("Loaded RenderChunk, initialising...");
			try {
				final int unused_renderChunksUpdated = RenderChunk.renderChunksUpdated;
				MOD_LOGGER.info("Initialised RenderChunk");
			} catch (Exception e) {
				final CrashReport crashReport = new CrashReport("Error initialising RenderChunk!", e);
				crashReport.makeCategory("Loading RenderChunk");
				throw new ReportedException(crashReport);
			}
		} catch (ReportedException e) {
			throw e;
		} catch (Exception e) {
			final CrashReport crashReport = new CrashReport("Error loading RenderChunk!", e);
			crashReport.makeCategory("Loading RenderChunk");
			throw new ReportedException(crashReport);
		}
		MOD_LOGGER.info("Successfully pre-loaded RenderChunk!");
	}

	static void preloadHooksForge() {
		MOD_LOGGER.info("Pre-loading RenderChunkRebuildChunkHooksHooks...");
		{
			RenderChunkRebuildChunkHooksHooks.class.getName();
			MOD_LOGGER.info("Loaded RenderChunkRebuildChunkHooksHooks, initialising...");
			try {
				Class.forName(RenderChunkRebuildChunkHooksHooks.class.getName(), true, Loader.instance().getModClassLoader());
			} catch (ClassNotFoundException e) {
				final CrashReport crashReport = new CrashReport("Error initialising RenderChunkRebuildChunkHooksHooks!", e);
				crashReport.makeCategory("Reflectively accessing RenderChunkRebuildChunkHooksHooks");
				throw new ReportedException(crashReport);
			}
			MOD_LOGGER.info("Initialised RenderChunkRebuildChunkHooksHooks");
		}
		MOD_LOGGER.info("Successfully pre-loaded RenderChunkRebuildChunkHooksHooks!");
	}

}
