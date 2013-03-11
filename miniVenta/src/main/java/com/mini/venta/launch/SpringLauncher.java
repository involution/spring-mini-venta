package com.mini.venta.launch;

import java.net.URL;

import javax.swing.ImageIcon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mini.venta.presentacion.Presentacion;
import com.mini.venta.vista.FrmLogin;

public class SpringLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = SpringLauncher.class.getResource("/images/miniventa.png");
			System.out.println("Instanciando imagen, url: " + url);
			ImageIcon myImage = new ImageIcon(url);
			System.out.println("Instanciando presentacion");
			Presentacion presentacion = new Presentacion(myImage);
			presentacion.setLocationRelativeTo(null);
//			presentacion.setProgresoMax(100);
			presentacion.setVisible(true);
//			presentacion.velocidadDeCarga();
			System.out.println("Presentacion visible");

			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");

			System.out.println("Quitando presentacion");
			presentacion.dispose();
			
			FrmLogin frmLogin = (FrmLogin) applicationContext.getBean("frmLogin");
			frmLogin.setLocationRelativeTo(null);			
			frmLogin.setVisible(true);
			
			/*System.out.println("url: " + url);
			
			for (int i = 0; i < 1000; i++) {
				for (int j = 0; j < 1000; j++) {
					System.out.println("i:" + i + " j:" + j);
				}
			}
			
			System.out.println("Quitando presentacion");
			presentacion.dispose();*/
			
//			TipoClienteService tipoClienteService = (TipoClienteService) applicationContext.getBean("tipoClienteServiceImpl");
//			for (TipoCliente tc : tipoClienteService.getListTipoClientes()) {
//				System.out.println(tc.getDescripcion());
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
