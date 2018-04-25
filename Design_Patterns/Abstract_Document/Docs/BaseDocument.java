

public abstract class BaseDocument implements Document {
    
    private final Map<String, Object> entries;
    protected BaseDocument(Map<String, Object> entries) {
        this.entries = requireNonNull(entries);
    }

    @Override
    public final Object put(String key, Object value) {
        return entries.put(key, value);
    }
    @Override
    public final Object get(String key) {
        return entries.get(key);
    }
    @Override
    public final <T> Stream<T> children(
            String key,
            Function<Map<String, Object>, T> constructor) {

        final List<Map<String, Object>> children = 
            (List<Map<String, Object>>) get(key);
        
        return children == null
                    ? Stream.empty()
                    : children.stream().map(constructor);
    }
}