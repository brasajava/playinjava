package com.brasajava;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class Application {
	private String[] nombres = {"Africa","Ricardo","Paulo","Suhaila"};
	private String[] apellidos = {"Chacopino","Moraes","Sandström","Gonçalves"};
	private List<Cuenta> banco;
	
	public Application(){
		banco = new ArrayList<Cuenta>();
		Cuenta cuentAfrica = new Cuenta();
		cuentAfrica.setDni("48624232r");
		cuentAfrica.setName("Africa Chacopino Chacopino");
		cuentAfrica.setSaldo(100000);
		cuentAfrica.setContrasena("Africa2");
		banco.add(cuentAfrica);
		Cuenta ricardoCuenta = new Cuenta();
		ricardoCuenta.setDni("y1580371d");
		ricardoCuenta.setName("Ricardo Maximino Gonçalves de Moraes");
		ricardoCuenta.setSaldo(90000);
		ricardoCuenta.setContrasena("Ricardo2");
		banco.add(ricardoCuenta);
	}
	@RequestMapping("/")
	@ResponseBody
    public String home() {
        return "Hello World! " + System.currentTimeMillis();
    }
	
	@RequestMapping("/Africa")
	@ResponseBody
    public String afri() {
        return "Hola mi amor, te amo mucho. No te preocupes por nada, porque yo estaré aqui";
    }

	@RequestMapping("/nombres")
	@ResponseBody
    public String name() {
		String name = nombres[(int) (Math.random()* nombres.length)];
		String apellido = apellidos[(int) (Math.random()* apellidos.length)];
        return name + " " + apellido;
    }
	
	@RequestMapping("/banco")
	@ResponseBody
    public String bank(@RequestParam("dni") String dni,@RequestParam("contrasena")String contrasena) {
		String result = "nada";
		for(Cuenta c : banco){
			if(c.getDni().equals(dni)){
				if(c.getContrasena().equals(contrasena)){
					result = c.getName() + " Saldo: " + c.getSaldo(); 
				}else{
					result = "Contraseña incorrecta";
				}
			}
		}
		return result;
    }
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
