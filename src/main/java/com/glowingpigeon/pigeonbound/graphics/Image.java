package com.glowingpigeon.pigeonbound.graphics;

import javafx.scene.canvas.*;

public class Image {
    private javafx.scene.image.Image img;
    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Constructs and image from a file
     * @param path The path to the image
     */
    public Image(String path) {
        img = new javafx.scene.image.Image(path);
        x = 0;
        y = 0;
        while (img.getProgress() < 1);
        this.width = (int) img.getWidth();
        this.height = (int) img.getHeight();
    }
    
    /**
     * Constructs an image as a subimage of a larger file from (0, 0)
     * @param path The path to the image
     * @param width The width of the subimage, in pixels
     * @param height The height of the subimage, in pixels
     */
    public Image(String path, int width, int height) {
        img = new javafx.scene.image.Image(path);
        x = 0;
        y = 0;
        this.width = width;
        this.height = height;
        // Wait until loaded
        while (img.getProgress() < 1);
    }
    
    /**
     * Constructs an image as a subimage of a larger file
     * @param path The path to the image
     * @param x The x of the top left of the subimage, in pixels
     * @param y The y of the top left of the subimage, in pixels
     * @param width The width of the subimage, in pixels
     * @param height The height of the subimage, in pixels
     */
    public Image(String path, int x, int y, int width, int height) {
        img = new javafx.scene.image.Image(path);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        while (img.getProgress() < 1);
    }
    
    public void render(GraphicsContext gc, int x, int y) {
        render(gc, x, y, width, height);
    }
    
    public void render(GraphicsContext gc, int x, int y, int width, int height) {
        gc.drawImage(img, this.x, this.y, this.width, this.height, x, y, width, height);
    }
}