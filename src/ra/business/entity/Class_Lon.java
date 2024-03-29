package ra.business.entity;

public class Class_Lon {
    private String Id;
    private String Name;
    private Boolean status;

    public Class_Lon(String id, String name, Boolean status) {
        Id = id;
        Name = name;
        this.status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Class_Lon() {
    }
    public void inputData(){}
}
