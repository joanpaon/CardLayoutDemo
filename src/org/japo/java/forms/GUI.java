/*
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.japo.java.events.MEM;
import org.japo.java.libraries.UtilesSwing;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class GUI extends JFrame {

    // Propiedades App
    public static final String PRP_LOOK_AND_FEEL = "look_and_feel";
    public static final String PRP_FAVICON = "favicon";

    // Valores por Defecto
    public static final String DEF_LOOK_AND_FEEL = UtilesSwing.LNF_NIMBUS;
    public static final String DEF_FAVICON = "img/favicon.png";

    // Referencias
    private Properties prp;
    private JPanel pnlPpal;
    private JLabel lblUno;
    private JLabel lblDos;
    private JLabel lblTre;
    private JLabel lblCua;
    private JLabel lblCin;
    private JLabel lblSei;

    // Constructor
    public GUI(Properties prp) {
        // Inicialización Anterior
        initBefore(prp);

        // Creación Interfaz
        initComponents();

        // Inicializacion Posterior
        initAfter();
    }

    // Construcción - GUI
    private void initComponents() {
        // Gestor Eventos Ratón
        MEM mem = new MEM(this);

        // Etiqueta Enero
        lblUno = new JLabel("1");
        lblUno.setHorizontalAlignment(JLabel.CENTER);
        lblUno.setFont(new Font("Beatnik SF", Font.BOLD, 150));
        lblUno.setOpaque(true);
        lblUno.setForeground(Color.WHITE);
        lblUno.setBackground(Color.BLUE);
        lblUno.addMouseListener(mem);

        // Etiqueta Febrero
        lblDos = new JLabel("2");
        lblDos.setHorizontalAlignment(JLabel.CENTER);
        lblDos.setFont(new Font("Beatnik SF", Font.BOLD, 150));
        lblDos.setOpaque(true);
        lblDos.setForeground(Color.WHITE);
        lblDos.setBackground(Color.RED);
        lblDos.addMouseListener(mem);

        // Etiqueta Marzo
        lblTre = new JLabel("3");
        lblTre.setHorizontalAlignment(JLabel.CENTER);
        lblTre.setFont(new Font("Beatnik SF", Font.BOLD, 150));
        lblTre.setOpaque(true);
        lblTre.setForeground(Color.WHITE);
        lblTre.setBackground(Color.MAGENTA);
        lblTre.addMouseListener(mem);

        // Etiqueta Abril
        lblCua = new JLabel("4");
        lblCua.setHorizontalAlignment(JLabel.CENTER);
        lblCua.setFont(new Font("Beatnik SF", Font.BOLD, 150));
        lblCua.setOpaque(true);
        lblCua.setForeground(Color.WHITE);
        lblCua.setBackground(Color.ORANGE);
        lblCua.addMouseListener(mem);

        // Etiqueta Mayo
        lblCin = new JLabel("5");
        lblCin.setHorizontalAlignment(JLabel.CENTER);
        lblCin.setFont(new Font("Beatnik SF", Font.BOLD, 150));
        lblCin.setOpaque(true);
        lblCin.setForeground(Color.WHITE);
        lblCin.setBackground(Color.PINK);
        lblCin.addMouseListener(mem);

        // Etiqueta Junio
        lblSei = new JLabel("6");
        lblSei.setHorizontalAlignment(JLabel.CENTER);
        lblSei.setFont(new Font("Beatnik SF", Font.BOLD, 150));
        lblSei.setOpaque(true);
        lblSei.setForeground(Color.WHITE);
        lblSei.setBackground(Color.CYAN);
        lblSei.addMouseListener(mem);

        // Panel Principal
        pnlPpal = new JPanel();
        pnlPpal.setLayout(new CardLayout());
        pnlPpal.add(lblUno);
        pnlPpal.add(lblDos);
        pnlPpal.add(lblTre);
        pnlPpal.add(lblCua);
        pnlPpal.add(lblCin);
        pnlPpal.add(lblSei);

        // Ventana Principal
        setContentPane(pnlPpal);
        setTitle("GridLayout Demo");
//        setResizable(false);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Inicialización Anterior    
    private void initBefore(Properties prp) {
        // Memorizar Referencia
        this.prp = prp;

        // Establecer LnF
        UtilesSwing.establecerLnF(prp.getProperty(PRP_LOOK_AND_FEEL, DEF_LOOK_AND_FEEL));
    }

    // Inicialización Anterior
    private void initAfter() {
        // Establecer Favicon
        UtilesSwing.establecerFavicon(this, prp.getProperty(PRP_FAVICON, DEF_FAVICON));
    }

    // Siguiente Carta
    public void procesarClick(MouseEvent e) {
        ((CardLayout) pnlPpal.getLayout()).next(pnlPpal);
    }
}
