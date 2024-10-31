public class Tanque 
{
    private int capacidad;
    private int carga;
    
    public tanque(int p_capacidad,int p_carga ){
        this.setCapacidad(p_capacidad);
        this.setCarga(p_carga);
    }

    private void setCapacidad(int p_capacidad)
    {
        this.capacidad=p_capacidad;
    }
    private void setCarga(int p_carga)
    {
        this.carga=p_carga;
    }

    public int getCapacidad()
    {
        return this.capacidad;
    }
    public int getCarga()
    {
        return this.carga;
    }

    public void agregarCarga(int p_litros)
    {
        if(p_litros + this.getCarga() > this.getCapacidad())
        { 
        throw new TanqueLlenoException("La cantidad de litros excede la capacidad");
        }else if(p_litros + this.getCarga()() <= this.getCapacidad())
        {
            this.setCarga(this.getCarga()+ p_litros);
        }
    }

    public void retirarCarga(int p_litros) throws TanqueVacioException {
       if (this.getCarga() == 0) {
           throw new TanqueVacioException("El tanque está vacío.");
      } else if (this.getCarga() < p_litros) {
          throw new IllegalArgumentException("No se puede quitar más litros de los que hay en el tanque.");
      } else {
        this.setCarga(this.getCarga() - p_litros);
        }
}

}