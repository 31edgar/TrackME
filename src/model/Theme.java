package model;

import java.awt.Color;
import java.awt.Font;

public class Theme {
    private final String name;
    private final Color primaryColor;
    private final Color secondaryColor;
    private final Color backgroundColor;
    private final Color textColor;
    private final Font font;

    public Theme(String name, Color primaryColor, Color secondaryColor,
                 Color backgroundColor, Color textColor, Font font,
                 String accentImagePath) {
        this.name = name;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.font = font;
    }

    // Getters
    public String getName() { return name; }
    public Color getPrimaryColor() { return primaryColor; }
    public Color getSecondaryColor() { return secondaryColor; }
    public Color getBackgroundColor() { return backgroundColor; }
    public Color getTextColor() { return textColor; }
    public Font getFont() { return font; }
}
