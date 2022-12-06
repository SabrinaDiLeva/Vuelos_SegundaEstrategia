import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Tripulacion> tripulaciones = new ArrayList<>();
        List<Vuelo> vuelos = new ArrayList<>();
        /*Vuelo vuelo1 = new Vuelo("V1", "Aeroparque","Mendoza",new Date(), new Date());
        Vuelo vuelo5 = new Vuelo("V5", "Aeroparque","Usuahia",new Date(), new Date());
        Vuelo vuelo2 = new Vuelo("V2", "Mendoza","Jujuy",new Date(), new Date());
        Vuelo vuelo3 = new Vuelo("V3", "Jujuy","Calafate",new Date(), new Date());
        Vuelo vuelo4 = new Vuelo("V4", "Calafate","Aeroparque",new Date(), new Date());
        Vuelo vuelo6 = new Vuelo("V6", "Usuahia","Aeroparque",new Date(), new Date());
        vuelos.add(vuelo1);
        vuelos.add(vuelo5);
        vuelos.add(vuelo2);
        vuelos.add(vuelo3);
        vuelos.add(vuelo4);
        vuelos.add(vuelo6);
        Tripulacion tripulacion1= new Tripulacion("T1","Aeroparque","Aeroparque");
        Tripulacion tripulacion2= new Tripulacion("T2","Aeroparque","Aeroparque");
        tripulaciones.add(tripulacion1);
        tripulaciones.add(tripulacion2);*/
        Vuelo vuelo1 = new Vuelo("V1", "Aeroparque","Usuahia",LocalDateTime.of(2022,10,21,10,0), LocalDateTime.of(2022,10,21,11,0));
        Vuelo vuelo2 = new Vuelo("V2", "Aeroparque","Jujuy",LocalDateTime.of(2022,10,21,9,0), LocalDateTime.of(2022,10,21,10,0));
        Vuelo vuelo3 = new Vuelo("V3", "Aeroparque","Usuahia",LocalDateTime.of(2022,10,22,8,0), LocalDateTime.of(2022,10,22,9,0));
        Vuelo vuelo4 = new Vuelo("V4", "Aeroparque","Jujuy",LocalDateTime.of(2022,10,22,7,0), LocalDateTime.of(2022,10,22,8,0));
        Vuelo vuelo5 = new Vuelo("V5", "Usuahia","Jujuy",LocalDateTime.of(2022,10,21,15,0), LocalDateTime.of(2022,10,21,16,0));
        Vuelo vuelo6 = new Vuelo("V6", "Usuahia","Aeroparque",LocalDateTime.of(2022,10,21,22,0), LocalDateTime.of(2022,10,21,23,0));
        Vuelo vuelo7 = new Vuelo("V7", "Usuahia","Jujuy",LocalDateTime.of(2022,10,22,12,0), LocalDateTime.of(2022,10,22,13,0));
        Vuelo vuelo8 = new Vuelo("V8", "Usuahia","Aeroparque",LocalDateTime.of(2022,10,22,19,0), LocalDateTime.of(2022,10,22,20,0));
        Vuelo vuelo9 = new Vuelo("V9", "Jujuy","Aeroparque",LocalDateTime.of(2022,10,21,19,0), LocalDateTime.of(2022,10,21,20,0));
        Vuelo vuelo10 = new Vuelo("V10", "Jujuy","Usuahia",LocalDateTime.of(2022,10,21,17,0), LocalDateTime.of(2022,10,21,18,0));
        Vuelo vuelo11 = new Vuelo("V11", "Jujuy","Aeroparque",LocalDateTime.of(2022,10,22,17,0), LocalDateTime.of(2022,10,22,18,0));
        Vuelo vuelo12 = new Vuelo("V12", "Jujuy","Usuahia",LocalDateTime.of(2022,10,22,15,0), LocalDateTime.of(2022,10,22,16,0));
        vuelos.add(vuelo1);
        vuelos.add(vuelo2);
        vuelos.add(vuelo3);
        vuelos.add(vuelo4);
        vuelos.add(vuelo5);
        vuelos.add(vuelo6);
        vuelos.add(vuelo7);
        vuelos.add(vuelo8);
        vuelos.add(vuelo9);
        vuelos.add(vuelo10);
        vuelos.add(vuelo11);
        vuelos.add(vuelo12);

        //ordenamos los vuelos según su hora de despegue
        vuelos.sort((o1,o2) -> o1.getFecha_despegue().compareTo(o2.getFecha_despegue()));

        Tripulacion tripulacion1= new Tripulacion("T1","Aeroparque");
        Tripulacion tripulacion2= new Tripulacion("T2","Aeroparque");
        Tripulacion tripulacion3= new Tripulacion("T3","Aeroparque");
        Tripulacion tripulacion4= new Tripulacion("T4","Aeroparque");
        tripulaciones.add(tripulacion1);
        tripulaciones.add(tripulacion2);
        tripulaciones.add(tripulacion3);
        tripulaciones.add(tripulacion4);
        List<Tripulacion> tripulacionesPosibles = new ArrayList<>();
        tripulacionesPosibles.add(tripulacion1);
        tripulacionesPosibles.add(tripulacion2);
        tripulacionesPosibles.add(tripulacion3);
        tripulacionesPosibles.add(tripulacion4);

        List<Tripulacion> solucion = new ArrayList<>();
        int etapa=0;
        LocalDateTime inicio =vuelos.get(0).getFecha_despegue().minusHours(2);
        int tarifaPorHora=60;
        int costoActual=0;
        int mejorCosto=1000000;
        List<Tripulacion> mejorSolucion = new ArrayList<>();
        asignarVuelos(solucion,vuelos,tripulaciones,etapa,tripulacionesPosibles, inicio,costoActual,mejorCosto,mejorSolucion);
    }
    public static void asignarVuelos(List<Tripulacion> solucionActual,List<Vuelo>vuelos,List<Tripulacion>tripulaciones, int etapa, List<Tripulacion> tripulacionesPosibles, LocalDateTime inicio, int costoActual, int mejorCosto, List<Tripulacion> mejorSolucion){
        System.out.println("----------------------------------------------ETAPA "+etapa);
        if (etapa<vuelos.size()){
            //selecciono un vuelo
            Vuelo vuelo = vuelos.get(etapa);
            System.out.println();
            System.out.println("el vuelo"+vuelo.getCodigo()+" tiene origen en "+vuelo.getOrigen()+" y destino en "+vuelo.getDestino());

            //selecciono una tripulacion
            for(Tripulacion tripulacion: tripulacionesPosibles){
                String ciudadActual= getCiudadActual(vuelos,solucionActual,tripulacion);
                System.out.println("La tripulacion "+tripulacion.getCodigo()+" esta en "+ciudadActual);
                inicio=getHoraAterrizaje(vuelos,solucionActual,tripulacion,etapa);

                //si estan en la misma ciudad y si da bien la hora
                long horas = ChronoUnit.HOURS.between(inicio,vuelo.getFecha_despegue());
                if(vuelo.getOrigen().equals(ciudadActual) && horas>=2){
                    solucionActual.add(etapa,tripulacion);
                    System.out.println("se asigno la tripulacion "+solucionActual.get(etapa).getCodigo());
                    long costoDeEsteVuelo=calcularCosto(horas);
                    costoActual+=costoDeEsteVuelo;
                    if(solucionActual.size()<vuelos.size()){
                        asignarVuelos(solucionActual,vuelos,tripulaciones,etapa+1,reestablecerTripulacionesPosibles(tripulaciones),inicio,costoActual,mejorCosto,mejorSolucion);
                    }else{
                        System.out.println("Ha terminado la asignacion");
                        if(costoActual<mejorCosto){
                            mejorSolucion=solucionActual;
                            for(int i=0; i<vuelos.size();i++){
                                System.out.println("VUELO " +vuelos.get(i).getCodigo()+": TRIPULACION: "+solucionActual.get(i).getCodigo());
                            }
                            System.out.println("COSTO FINAL: U$D"+costoActual);
                        }
                    }
                    break;
                }else{
                    System.out.println("no se puede asignar la tripulacion "+tripulacion.getCodigo()+ "porque esta en "+ciudadActual);
                    List<Tripulacion> tripulacionesDescartadas =vuelo.getDescartados();
                    tripulacionesDescartadas.add(tripulacion);
                    vuelo.setDescartados(tripulacionesDescartadas);

                }
            }
            if(solucionActual.size()<vuelos.size()){
                System.out.println("al vuelo "+vuelo.getCodigo()+" no se le pudo asignar ninguna tripulacion");
                System.out.println("hay que volver para atras");
                long costoDeEsteVuelo=calcularCosto(ChronoUnit.HOURS.between(inicio,vuelo.getFecha_despegue()));
                costoActual-=costoDeEsteVuelo;
                tripulacionesPosibles=reestablecerTripulacionesPosibles(tripulaciones);

                if(etapa>0){
                    int etapaAnterior=etapa-1;
                    System.out.println(solucionActual.get(etapaAnterior).getCodigo() +" no puede ser asignada al vuelo "+etapa );
                    List<Tripulacion> tripulacionesDescartadas =vuelo.getDescartados();
                    tripulacionesDescartadas.add(solucionActual.get(etapaAnterior));
                    vuelo.setDescartados(tripulacionesDescartadas);
                    tripulacionesPosibles.removeAll(tripulacionesDescartadas);

                    tripulacionesPosibles.remove(solucionActual.get(etapa-1));
                    solucionActual.remove(etapa-1);
                    asignarVuelos(solucionActual,vuelos,tripulaciones,etapa-1,tripulacionesPosibles,inicio,costoActual,mejorCosto,mejorSolucion);
                }else{
                    System.out.println("No hay solución para este conjunto de vuelos");
                    //EXIT
                }
            }
        }
    }
    public static String getCiudadActual(List<Vuelo> vuelos,List<Tripulacion> solucionActual, Tripulacion tripulacion){
        String ciudad ="Aeroparque";
        int i=0;
        for(Tripulacion s :solucionActual){
            if(s.getCodigo().equals(tripulacion.getCodigo())){
                ciudad= vuelos.get(i).getDestino();
            }
            i++;
        }
        return ciudad;
    }

    public static LocalDateTime getHoraAterrizaje(List<Vuelo> vuelos,List<Tripulacion> solucionActual, Tripulacion tripulacion, int etapa){
        LocalDateTime hora = vuelos.get(etapa).getFecha_despegue().minusHours(2);
        int i=0;
        for(Tripulacion s :solucionActual){
            if(s.getCodigo().equals(tripulacion.getCodigo())){
                hora= vuelos.get(i).getFecha_aterrizaje();
            }
            i++;
        }
        return hora;
    }
    public static List<Tripulacion> reestablecerTripulacionesPosibles(List<Tripulacion> tripulaciones){
        List<Tripulacion> tripulacionesPosibles = new ArrayList<>();
        for(Tripulacion tripulacion : tripulaciones){
            tripulacionesPosibles.add(tripulacion);
        }
        return tripulacionesPosibles;
    }

    public static long calcularCosto(long horas){
        long horasParaPagar = horas-2;
        long costoDeEsteVuelo=60*horasParaPagar;
        return costoDeEsteVuelo;
    }

}