import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vuelo {
    private String codigo;
    private String origen;
    private String destino;
    private LocalDateTime fecha_despegue;
    private LocalDateTime fecha_aterrizaje;
    private Tripulacion tripulacion;

    private List<Tripulacion> descartados = new ArrayList<>();

    public Vuelo(String codigo, String origen, String destino, LocalDateTime fecha_despegue, LocalDateTime fecha_aterrizaje) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.fecha_despegue = fecha_despegue;
        this.fecha_aterrizaje = fecha_aterrizaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getFecha_despegue() {
        return fecha_despegue;
    }

    public void setFecha_despegue(LocalDateTime fecha_despegue) {
        this.fecha_despegue = fecha_despegue;
    }

    public LocalDateTime getFecha_aterrizaje() {
        return fecha_aterrizaje;
    }

    public void setFecha_aterrizaje(LocalDateTime fecha_aterrizaje) {
        this.fecha_aterrizaje = fecha_aterrizaje;
    }

    public Tripulacion getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(Tripulacion tripulacion) {
        this.tripulacion = tripulacion;
    }

    public List<Tripulacion> getDescartados() {
        return descartados;
    }

    public void setDescartados(List<Tripulacion> descartados) {
        this.descartados = descartados;
    }
}