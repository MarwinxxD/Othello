package game;

public class Disc {
    String color;
    int posX;
    int posY;

    public Disc(String _color) {
        try{
            setColor(_color);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setColor(String _color) throws IllegalArgumentException{
        if (_color.equalsIgnoreCase("black") || _color.equalsIgnoreCase("white")) {
            color = _color;
        } else {
            throw new IllegalArgumentException("Invalid color");
        }
    }

    public String getColor() {
        return this.color;
    }


    public void setPosX(int _posX) throws IllegalArgumentException {
        if(_posX >= 0 && _posX <= 8) {
            posX = _posX;
        } else {
            throw new IllegalArgumentException("Invalid posX");
        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosY(int _posY) throws IllegalArgumentException {
        if(_posY >= 0 && _posY <= 8) {
            posY = _posY;
        } else {
            throw new IllegalArgumentException("Invalid posY");
        }
    }

    public int getPosY() {
        return posY;
    }
}
