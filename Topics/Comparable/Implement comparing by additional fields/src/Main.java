class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        int result = Integer.valueOf(getSize()).compareTo(otherArticle.getSize());

        if (result == 0) {
            return getTitle().compareTo(otherArticle.getTitle());
        } else {
            return result;
        }
    }
}