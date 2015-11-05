package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Image image = new Image("./images-grayscale/Input.png");
        String message = "Call Of Duty.";
        hideMessage(image, message);
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
        image.getPixelAt(10,10);

        //System.out.println(getMessageFromImage(new Image("./images-grayscale/Output.png")));
    }

    private static void hideMessage(Image image, String message) throws IOException {
        Converter converter = new Converter();
        String binaryText = converter.textToBinaryString(message);
        int counter = 0;
        try {
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    image.setLSBPixelAt(x, y, binaryText.charAt(counter));
                    counter++;
                }
            }
        }
        catch (Exception ex){
            if(counter == binaryText.length())
                System.out.println("DONE");
        }
        image.writeAsImageToFile("./images-grayscale/Output.png");
    }

    private static String getMessageFromImage(Image image) throws IOException {
        Converter converter = new Converter();
        String binaryString = "";
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                binaryString += image.getLSBPixelAt(x, y);
            }
        }
        return converter.binaryStringToText(binaryString);
    }
}
