package _06_frogger;

import processing.core.PApplet;
import processing.core.PImage;

public class Frogger extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    int frogX = WIDTH/2;
    int frogY = 520;
    int hopDistance = 27;
    
    PImage back;
    PImage carLeft;
    PImage carRight;
    PImage frog;
    
    Car car1, car2, car3, car4;
    
    
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
    	
        back = loadImage("_06_frogger/froggerBackground.png");
        back.resize(WIDTH, HEIGHT);
        carLeft = loadImage("_06_frogger/carLeft.png");
        carLeft.resize(160,100);
        carRight = loadImage("_06_frogger/carRight.png");
        carRight.resize(160,100);
        frog = loadImage("_06_frogger/frog.png");
        frog.resize(100,100);

    	
    	car1 = new Car(100,120,160,5);
    	car2 = new Car(500,200,160,7);
    	car3 = new Car(700,290,160,6);
    	car4 = new Car(200,360,160,4);
    	

    	
    }

    @Override
    public void draw() {
    	

    	
        background(back);
        
        image (carLeft,car1.getX(),car1.getY());
        image (carRight,car2.getX(),car2.getY());
        image (carLeft,car3.getX(),car3.getY());
        image (carLeft,car4.getX(),car4.getY());


        
    	//background(10,20,30);
    	//fill(5, 160, 20);
    	
    	//ellipse(frogX, frogY, 50, 50);
        image (frog, frogX, frogY);
    	
//    	car1.display();
//    	car2.display();
//    	car3.display();
//    	car4.display();
    	
    	car1.moveLeft();
    	car2.moveRight();
    	car3.moveLeft();
    	car4.moveLeft();
    	
    	if (intersects(car1) || intersects(car2) || intersects(car3) || intersects(car4)) {
    		frogY = 550;
    	}
    	


    }
    
    static public void main(String[] args) {
        PApplet.main(Frogger.class.getName());
    }
    
    public void keyPressed() {
        if(key == CODED){
            if(keyCode == UP && frogY - hopDistance > 0)
            {
            	frogY -= hopDistance;
            }
            else if(keyCode == DOWN && frogY + hopDistance < HEIGHT)
            {
            	frogY += hopDistance;
            }
            else if(keyCode == RIGHT && frogX + hopDistance < WIDTH)
            {
                frogX += hopDistance;
            }
            else if(keyCode == LEFT && frogX - hopDistance > 0)
            {
            	frogX -= hopDistance;
            }
        }
    }
    
    boolean intersects(Car car) {
    	 if ((frogY > car.getY() && frogY < car.getY()+car.getSize()) &&
    	                (frogX > car.getX() && frogX < car.getX()+car.getSize())) {
    	   return true;
    	  }
    	 else  {
    	  return false;
    	 }
    }


    public class Car {

    	private int carX, carY, carSize, carSpeed;
		
    	public Car(int carX, int carY, int carSize, int carSpeed) {
			
    		this.carX = carX;
    		this.carY = carY;
    		this.carSize = carSize;
    		this.carSpeed = carSpeed;
		
    	}
	
    	public void display() {	
    		fill(0,255,0);
    		rect(carX, carY, carSize, carSize);
    	}
    	
    	public void moveLeft() {
    		carX -= carSpeed;
    		if ( carX < 0 - carSize) {
    			carX = WIDTH;
    		}
    	}
    	
    	public void moveRight() {
    		carX += carSpeed;
    		if ( carX > WIDTH) {
    			carX = 0 - carSize;
    		}
    	}
    	
    	public int getX() {
    		return carX;
    	}
    	
    	public int getY() {
    		return carY;
    	}
    	
    	public int getSize() {
    		return carSize;
    	}
    }
}

