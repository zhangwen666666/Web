public class Bug {
    private String id;
    private String desc;
    private boolean selected;

    @Override
    public String toString() {
        return "Bug{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", resolved=" + selected +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Bug(String id, String desc, boolean resolved) {
        this.id = id;
        this.desc = desc;
        this.selected = resolved;
    }

    public Bug() {
    }
}
