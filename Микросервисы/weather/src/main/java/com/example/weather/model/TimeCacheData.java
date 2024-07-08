package com.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeCacheData {
    private long time2cache;
    private Root root;

    public TimeCacheData(long time2cache, Root root)
    {
        this.time2cache = time2cache;
        this.root = root;
    }

    public Root getRoot() {
        return root;
    }

    public long getTime2cache() {
        return time2cache;
    }
}
