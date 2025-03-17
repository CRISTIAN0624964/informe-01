class Verificador {

    public static boolean seSobreponen(Rectangulo a, Rectangulo b) {
        return !(a.getEsquina2().getX() < b.getEsquina1().getX() ||
                a.getEsquina1().getX() > b.getEsquina2().getX() ||
                a.getEsquina2().getY() < b.getEsquina1().getY() ||
                a.getEsquina1().getY() > b.getEsquina2().getY());
    }

    public static boolean estanJuntos(Rectangulo a, Rectangulo b) {
        return !seSobreponen(a, b) && (a.getEsquina2().getX() == b.getEsquina1().getX() ||
                a.getEsquina1().getX() == b.getEsquina2().getX() ||
                a.getEsquina2().getY() == b.getEsquina1().getY() ||
                a.getEsquina1().getY() == b.getEsquina2().getY());
    }

    public static Rectangulo rectanguloSobre(Rectangulo a, Rectangulo b) {
        double x1 = Math.max(a.getEsquina1().getX(), b.getEsquina1().getX());
        double y1 = Math.max(a.getEsquina1().getY(), b.getEsquina1().getY());
        double x2 = Math.min(a.getEsquina2().getX(), b.getEsquina2().getX());
        double y2 = Math.min(a.getEsquina2().getY(), b.getEsquina2().getY());

        if (x1 < x2 && y1 < y2) {
            return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
        } else {
            return null;
        }
    }
}