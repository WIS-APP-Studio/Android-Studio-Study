package com.example.post;

public class PostData {
//    private int image;
    private String writer;
    private String title;
    private String description;

    public PostData(/*int image,*/String writer, String title, String description){
//        this.image = image;
        this.writer = writer;
        this.title = title;
        this.description = description;
    }

//    public int getImage()
//    {
//        return this.image;
//    }

    public String getWriter()
    {
        return this.writer;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getDescription()
    {
        return this.description;
    }
}
