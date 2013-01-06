package def;

public class Camera {

	public int x = 0, y = 0;
	public int dx = 0, dy = 0;

	public Camera() {

	}

	public void RunCam() {
		if (!Engine.editMode) {
			x = (Engine.mb.MOBS[0].finalx * -1) + 500;
			y = (Engine.mb.MOBS[0].finaly * -1) + 200;
			x = x + dx;
			y = y + dy;
		}else{
			x=x+dx;
			y=y+dy;
		}
	}

	public void move(int dir) {
		if (dir == def.Frame.LEFT) {
			dx = Frame.SPEED;
			dy = 0;
		}
		if (dir == def.Frame.RIGHT) {
			dx = -Frame.SPEED;
			dy = 0;
		}
		if (dir == def.Frame.UP) {
			dy = Frame.SPEED;
			dx = 0;
		}
		if (dir == def.Frame.DOWN) {
			dy = -Frame.SPEED;
			dx = 0;
		}
		if (dir == def.Frame.STILL) {
			dy = 0;
			dx = 0;
		}
	}

}
