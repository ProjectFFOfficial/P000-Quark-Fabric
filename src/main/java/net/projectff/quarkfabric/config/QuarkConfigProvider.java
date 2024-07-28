package net.projectff.quarkfabric.config;

import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuarkConfigProvider implements SimpleConfigAPI.DefaultConfig {
    private String configContents = "";

    private final List<Pair> configList = new ArrayList<>();

    public List<Pair> getConfigList() {
        return this.configList;
    }
    public void rawIncersion(String string) {
        this.configContents += string;
    }
    public void newLine(int new_lines) {
        if (new_lines > 0) {
            this.configContents += '\n';
            newLine(new_lines - 1);
        }
    }
    public void comment(String comment) {
        this.configContents += "# " + comment + '\n';
    }
    public void add(String key, Object value) {
        this.configList.add(new Pair<>(key, value));
        comment("type: " + value.getClass().getName() + "default value: " + value);
        this.configContents += key + " = " + value + '\n';
    }
    public void add(String key, Object value, String comment) {
        comment(comment);
        add(key, value);
    }

    @Override
    public String get(String namespace) {
        return configContents;
    }
}
