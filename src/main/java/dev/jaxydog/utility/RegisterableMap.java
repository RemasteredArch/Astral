package dev.jaxydog.utility;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import dev.jaxydog.utility.register.Registerable;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;

public abstract class RegisterableMap<K, V extends Registerable> implements Registerable.All {

	private final String RAW_ID;
	private final HashMap<K, V> INNER;

	public RegisterableMap(String rawId, Supplier<K[]> keys, BiFunction<String, K, V> constructor,
			Function<K, String> stringifier) {
		this.RAW_ID = rawId;
		this.INNER = new HashMap<>(keys.get().length);

		for (final K key : keys.get()) {
			final String id = String.format("%s_%s", stringifier.apply(key), this.getRawId());
			final V value = constructor.apply(id, key);

			this.INNER.put(key, value);
		}
	}

	public final V get(K key) {
		return this.INNER.get(key);
	}

	public final Collection<V> getAll() {
		return this.INNER.values();
	}

	@Override
	public final String getRawId() {
		return this.RAW_ID;
	}

	@Override
	public void registerMain() {
		for (final V value : this.INNER.values()) {
			if (value instanceof final Registerable.Main main) {
				main.registerMain();
			}
		}
	}

	@Override
	public void registerClient() {
		for (final V value : this.INNER.values()) {
			if (value instanceof final Registerable.Client client) {
				client.registerClient();
			}
		}
	}

	@Override
	public void registerServer() {
		for (final V value : this.INNER.values()) {
			if (value instanceof final Registerable.Server server) {
				server.registerServer();
			}
		}
	}

	@Override
	public void registerDatagen(Pack pack) {
		for (final V value : this.INNER.values()) {
			if (value instanceof final Registerable.Datagen datagen) {
				datagen.registerDatagen(pack);
			}
		}
	}

}
