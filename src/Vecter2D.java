public class Vecter2D {
    public float x;
    public float y;

    public Vecter2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vecter2D() {
        this.x = 0;
        this.x = 0;
    }

    public Vecter2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vecter2D set(Vecter2D vecter2D) {
        return this.set(vecter2D.x, vecter2D.y);
    }

    public Vecter2D addUp(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vecter2D addUp(Vecter2D vecter2D) {
        return this.addUp(vecter2D.x, vecter2D.y);
    }

    public Vecter2D add(float x, float y) {
        return new Vecter2D(this.x + x, this.y + y);
    }

    public Vecter2D add(Vecter2D vecter2D) {
        return this.add(vecter2D.x, vecter2D.y);
    }

    public Vecter2D subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vecter2D subtractBy(Vecter2D vecter2D) {
        return this.subtractBy(vecter2D.x, vecter2D.y);
    }

    public Vecter2D subtract(float x, float y) {
        return new Vecter2D(this.x - x, this.y - y);
    }

    public Vecter2D subtract(Vecter2D vecter2D) {
        return this.subtract(vecter2D.x, vecter2D.y);
    }

    public Vecter2D multiplyUp(float number) {
        this.x *= number;
        this.y *= number;
        return  this;
    }

    public Vecter2D multiply(float number) {
        return new Vecter2D(this.x * number, this.y * number);
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vecter2D copy() {
        return new Vecter2D(x, y);
    }

    public Vecter2D normalize() {
        float length = this.length();
        return new Vecter2D(x / length, y / length);
    }

    public Vecter2D rotate(double angle) {
        double radian = Math.toRadians(angle);
        double cs = Math.cos(radian);
        double sn = Math.sin(radian);
        return new Vecter2D((float) (x * cs - y * sn), (float) (x * sn + y * cs));
    }
}
