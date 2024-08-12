package complements;
public class Register {
    private String id;
    private GenericValue value;

    public String getId() {
        return id;
    }

    public void setValue(GenericValue value) {
        this.value = value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GenericValue getValue() {
        return value;
    }

    public Register(String id , GenericValue value) {
        this.id = id;
        this.value = value;
    }
    
}
