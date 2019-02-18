package io.confluent.kpay.util;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;

public class StoreProvider<K, V> {

    private KafkaStreams streams;
    KTable<K, V> table;

    public StoreProvider(KafkaStreams streams, KTable<K, V> table) {

        this.streams = streams;
        this.table = table;
    }

    public ReadOnlyKeyValueStore<K, V> getStore() {
        return streams.store(table.queryableStoreName(), QueryableStoreTypes.keyValueStore());
    }
}
