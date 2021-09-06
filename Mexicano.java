/* Para poder generar la homoclave me guie  en el codigo del siguiente sitio web:
https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
*/
package practica3;

import java.util.Random;

/**
 *
 * @author luis0
 */
public class Mexicano {
    String nombre;
    String segundoNombre;
    String apellidop;
    String apellidom;
    char sexo;
    int dia_nacimiento;
    int mes_nacimiento;
    int year_nacimiento;
    String lugar_nacimiento;
    String CURP;
    String RFC;
    private final String homoclave = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public Mexicano()
    {
        setNombre(CapturaEntrada.capturarCadena("Primer nombre"));
        setNombre2(CapturaEntrada.capturarCadena("Segundo nombre (Si no tiene favor de poner 0)"));
        setApellidop(CapturaEntrada.capturarCadena("Apellido paterno"));
        setApellidom(CapturaEntrada.capturarCadena("Apellido materno (Si no tiene favor de poner 0)"));
        setSexo(CapturaEntrada.capturarCadena("Sexo").charAt(0)); //Caputura solo un caracter de infomacion
        setDia(CapturaEntrada.capturarEntero("Dia de nacimiento"));
        setMes(CapturaEntrada.capturarEntero("Mes de nacimiento"));
        setYear(CapturaEntrada.capturarEntero("Año de nacimiento"));
        setLugarNacimiento(CapturaEntrada.capturarCadena("Lugar de nacimiento"));
        generarCURP(generar());
        generarRFC(generar());
        
        
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre2(String nombre2)
    {
       segundoNombre = nombre2;
    }
    public String getNombre2()
    {
        return segundoNombre;
    }
    public void setApellidom(String apellidom)
    {
        this.apellidom = apellidom;
    }
    public String getApellidom()
    {
        return apellidom;
    }
    public void setApellidop(String apellidop)
    {
        this.apellidop = apellidop;
    }
    public String getApellidop()
    {
        return apellidop;
    }
    public void setSexo(char sexo)
    {
        this.sexo = sexo;
    }
    public char getSexo()
    {
        return sexo;
    }
    public void setDia(int dia_nacimiento)
    {
        this.dia_nacimiento = dia_nacimiento;
    }
    public int getDia()
    {
        return dia_nacimiento;
    }
    public void setMes(int mes_nacimiento)
    {
        this.mes_nacimiento = mes_nacimiento;
    }
        public int getMes()
    {
        return mes_nacimiento;
    }
    public void setYear(int year_nacimiento)
    {
        this.year_nacimiento = year_nacimiento;
    }
    public int getYear()
    {
        return year_nacimiento;
    }
    public void setLugarNacimiento(String lugar)
    {
        lugar = lugar.trim().toLowerCase(); //Convierte a minusculas el lugar de nacimiento
        switch(lugar) //busca en que estado nacio y lo asigna al atributo lugar_nacimiento
        {
            case "aguascalientes" ->
            {
                lugar_nacimiento = "AS";            
            }
            case "baja california" ->
            {
                lugar_nacimiento = "BC";             
            }
            case "baja california sur" ->
            {
                lugar_nacimiento = "BS";            
            }
            case "campeche" ->
            {
                lugar_nacimiento = "CC";           
            }
            case "coahuila" ->
            {
                lugar_nacimiento = "CL";           
            }
            case "colima" ->
            {
                lugar_nacimiento = "CM";           
            }
            case "chiapas" ->
            {
                lugar_nacimiento = "CS";          
            }
            case "chihuahua" ->
            {
                lugar_nacimiento = "CH";           
            }
            case "distrito federal" ->
            {
                lugar_nacimiento = "DF";           
            }
            case "durango" -> 
            {
                lugar_nacimiento = "DG";            
            }
            case "guanajuato" -> 
            {
                lugar_nacimiento = "GT";            
            }
            case "guerrero" ->
            {
                lugar_nacimiento = "GR";           
            }
            case "hidalgo" ->  
            {
                lugar_nacimiento = "HG";           
            }
            case "jalisco" ->         
            {
                lugar_nacimiento = "JC";          
            }
            case "mexico" ->           
            {
                lugar_nacimiento = "MC";             
            }
            case "michoacan" ->         
            {
                lugar_nacimiento = "MN";           
            }
            case "morelos" ->           
            {
                lugar_nacimiento = "MS";            
            }
            case "nayarit" ->           
            {
                lugar_nacimiento = "NT";           
            }
            case "nuevo leon" ->           
            {
                lugar_nacimiento = "NL";         
            }
            case "oaxaca" ->            
            {
                lugar_nacimiento = "OC";           
            }
            case "puebla" ->             
            {
                lugar_nacimiento = "PL";           
            }
            case "queretaro" ->            
            {
                lugar_nacimiento = "QT";           
            }
            case "quintana roo" ->          
            {
                lugar_nacimiento = "QR";           
            }
            case "san luis potosi" ->         
            {
                lugar_nacimiento = "SP";            
            }
            case "sinaloa" ->           
            {
                lugar_nacimiento = "SL";           
            }
            case "sonora" ->            
            {
                lugar_nacimiento = "SR";          
            }
            case "tabasco" ->            
            {
                lugar_nacimiento ="TC";           
            }
            case "tamaulipas" ->          
            {
                lugar_nacimiento = "TS";           
            }
            case "tlaxcala" ->            
            {
                lugar_nacimiento = "TL";           
            }
            case "veracruz" ->            
            {
                lugar_nacimiento = "VZ";            
            }
            case "yucatan" ->            
            {
                lugar_nacimiento = "YN";            
            }
            case "zacatecas" ->
            {
                lugar_nacimiento = "ZC";            
            }
            case "nacido en el extranjero" ->
            {
                lugar_nacimiento = "NE";            
            }
        }
    }

    public String generar() //Generar sirve para obtener los primeros caracteres que serviran tanto para la CURP como para el RFC
    {
        String crp;
        if(apellidop.toLowerCase().charAt(0) == 'ñ') //Si el apellido empiza con ñ se cambia por una x
        {
             crp = "X"; //Primera letra del apellido
        }
        else
        {
             crp = String.valueOf(apellidop.toLowerCase().charAt(0)); //Primera letra del apellido
         }
        for(int i = 1; i< apellidop.length();i++)
        {
            if(apellidop.charAt(i) == 'a'|| apellidop.charAt(i) == 'e' || apellidop.charAt(i) == 'i'|| apellidop.charAt(i) == 'o'|| apellidop.charAt(i) == 'u')
            {
                crp+= String.valueOf(apellidop.charAt(i)); //Primera vocal del primer apellido
                break; //Sale del ciclo for una vez encontrada la primera vocal
            }
        }
        if(apellidom.equals("0")) //Si no tiene segundo apellido se colocara 0
        {
            crp+="x"; //si no tiene segundo apelldo se coloca x
        }
        else
        {
            crp+= apellidom.charAt(0); //Primer letra del segundo apellido
        }
        if(nombre.trim().toLowerCase().equals("maria")|| nombre.trim().toLowerCase().equals("jose"))//si los nombres jose o maria son primero se tomara del segundo nombre
        {
            crp+= String.valueOf(segundoNombre.charAt(0)); //si el primer nombre es maria o jose se toma la primera letra del segundo
        }
        else
        {
            crp+= String.valueOf(nombre.charAt(0)); // si no es maria o jose se toma el primer nombre
        }
        if(crp.toLowerCase().equals("vaca")|| crp.toLowerCase().equals("joto")| crp.toLowerCase().equals("pene")||crp.toLowerCase().equals("cola")||crp.toLowerCase().equals("pedo")||crp.toLowerCase().equals("puto")||crp.toLowerCase().equals("pito"))
        {//valida que no se genere palabras curiosas o antisonantes
           crp = String.valueOf(crp.charAt(0)) + String.valueOf(crp.charAt(1)) + String.valueOf(crp.charAt(2)) + "X";
        }
        String year = String.valueOf(year_nacimiento); //se crea un string con el valor del año de nacimiento
        crp+= String.valueOf(year.charAt(year.length()-2)) + String.valueOf(year.charAt(year.length()-1)); //se toman los ultimos dos caracteres del string del año
        if(mes_nacimiento >= 1 && mes_nacimiento <= 9) 
        {
            crp+= "0" + String.valueOf(mes_nacimiento); //si solo es un digito se le agrega 0
        }
        else
        {
            crp+= String.valueOf(mes_nacimiento);
        }
        if(dia_nacimiento >= 1 && dia_nacimiento <= 9)
        {
            crp+= "0" + String.valueOf(dia_nacimiento); //si solo es un digito se le agrega 0
        }
        else
        {
            crp+= String.valueOf(dia_nacimiento);
        }
        return crp; //regresa los primeros caracteres que serviran para RFC y CURP
        
    }   
    public void generarCURP(String curp) //recibe los primeros caracteres 
    {
        curp = curp.toLowerCase(); 
        curp += String.valueOf(sexo); //agrega el caracter del sexo
        curp+= lugar_nacimiento; //agrega los caracteres del lugar de nacimiento
        for(int i = 1; i< apellidop.length();i++)
        {
            if(apellidop.toLowerCase().charAt(i) != 'a' && apellidop.toLowerCase().charAt(i) != 'e' && apellidop.toLowerCase().charAt(i) != 'i' && apellidop.toLowerCase().charAt(i) != 'o' && apellidop.toLowerCase().charAt(i) != 'u')
            { //para agregar la segunda consonante de primer apellido se valida que no sea vocal
                if(apellidop.toLowerCase().charAt(i) == 'ñ')//si la consonante es ñ se agrega x
                {
                    curp+="x"; 
                }
                else
                {
                    curp+= String.valueOf(apellidop.charAt(i)); //Segunda consonante del primer apellido
                    
                }
                break; //Sale del ciclo for una vez encontrada la segunda consonante
            }
        }
        if(apellidom.equals("0"))
        {
            curp+="x"; //si no tiene segundo apelldo se coloca x
        }
        else
        {
            for(int i = 1; i< apellidom.length();i++)
            {
                if(apellidom.charAt(i) != 'a' && apellidom.charAt(i) != 'e' && apellidom.charAt(i) != 'i'&& apellidom.charAt(i) != 'o'&& apellidom.charAt(i) != 'u')
                {
                    curp+= String.valueOf(apellidom.charAt(i)); //Segunda consonante del segundo apellido
                    break; //Sale del ciclo for una vez encontrada la segunda consonante
                }
            }
        }
        for(int i = 1; i< nombre.length();i++)
        {
            if(nombre.charAt(i) != 'a' && nombre.charAt(i) != 'e' && nombre.charAt(i) != 'i' && nombre.charAt(i) != 'o'&& nombre.charAt(i) != 'u')
            {
                curp+= String.valueOf(nombre.charAt(i)); //Segunda consonante del primer nombre
                break; //Sale del ciclo for una vez encontrada la segunga consonante del primer nombre
            }
        }
        StringBuilder homo = new StringBuilder(); //Crea un string
        Random aleatorio = new Random(); //creamos un objeto aleatorio
        while (homo.length() < 2)//el 2 corresponde al los caracteres que se van a generar aleatoriamente
        {
            int index = (int) (aleatorio.nextFloat() * homoclave.length());
            homo.append(homoclave.charAt(index));
        }
         curp+= homo.toString();
        CURP = curp.toUpperCase();
    }
    public void generarRFC(String rfc)
    {
        StringBuilder homo = new StringBuilder(); //Crea un string 
        Random aleatorio = new Random(); //crea un objeto random
        while (homo.length() < 3) //el 3 corresponde al los caracteres que se van a generar aleatoriamente
        {
            int index = (int) (aleatorio.nextFloat() * homoclave.length());
            homo.append(homoclave.charAt(index));
        }
         rfc+= homo.toString();//convierte los caracteres dados a string y lo agrega al rfc
        RFC = rfc.toUpperCase();
    }
    public String getCURP()
    {
        return CURP;
    }
    public String getRFC()
    {
        return RFC;
    }
}

