class Badge {
    public String print(Integer id, String name, String department) {

        StringBuilder sb = new StringBuilder();
        if(id != null) {
            sb.append("[").append(id).append("] ");
        }
        if (name != null) {
            if(id != null) {
                sb.append("- ").append(name);
            } else {
                sb.append(name);
            }
        }

        if (department != null) {
            sb.append(" - ").append(department.toUpperCase());
        } else {
            sb.append(" - OWNER");
        }
        return sb.toString();
    }
}
