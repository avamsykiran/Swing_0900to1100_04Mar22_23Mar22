Java Swing
-----------------------------------------------------------------------------

    Swing   is a GUI development library.

    javax.swing package

    AWT     Abstract Window Toolkit

        - not platform independent
        - limited component support
        - does not support pluggable look and feel
        - does nto support MVC design pattern .

    Swing

        + Platform independnet
        + Pluggable look and feel
        + Vast list of component 
        + Supports MVC design pattern at archetecture.

    Components

        a component is any gui control / element that appers on the screen.

        javax.swing.JComponent
                        JLabel
                        JTextField
                        JPasswordFeild
                        JTextPane
                        JButton
                        JRadioButton
                        JCheckBox
                        JToggelButton
                        JTabbedPane
                        JScrollPane
                        JPanel
                        JWindow
                        JFrame
                        JDialog
                        JScrollbar
                        JTree
                        JList
                            ...etc
    Layouts

        a layout controls how shall the components be arranged on the window.

        java.awt.LayoutManager
                    FlowLayout          is the default layout of JPanel
                    BorderLayout        is the default layout of JFrame and JDialog                    
                    GridLayout
                    BoxLayout                    
                    GridBagLayout
                    CardLayout
                    GroupLayout
                    SpringLayout
                        ...etc

        Create a Wizard for accepting the deaitls of a new recrutee....
            firstPanel - collect personal details
            secondPanel - collect his educational qualification details
            thirdPanel - collect his experience details

            buttonsPanel - prev button and a next button

    Events

        a event is any thing that happens on a component. eg: clicking, moving mouse pointer,
        pressing the button ...etc

        ActionEvent
        ItemEvent
        SelectionEvent ...etc

    Listeners

        is an interface that has to be implemented to provide evnet handling.

        ActionListener
        ItemListener
        SelectionListener
        WindowListener
        MouseListener ...etc

    Adaptars
    
        is a abastract class that implements a listener interface and overrides all
        those methodw with empty implementation.

    Model-View-Controller Archetecure
    ---------------------------------------------------------------------------------

        DB <--> [ DAO --entity-- Service --model-- Controller --model-- View ] <--> EndUser

                                                                GUI-Swing               Web-Servlets/JSP
        DAO         persistence Logic                           POJO                    POJO
        Service     bussiness Logic                             POJO                    POJO
        Controller  Application Flow Logic                      Listener/Adapter        Servlet
        View        User Interaction (Presentation Logic)       JPanel/JFrame/JDialog   JSP

        Entity      Represents Database Data                    POJO                    POJO
        Model       Represents the Visual Data                  Swing Model             POJO

    Adding external libraries like (sajdbc.jar) to maven
    ----------------------------------------------------------------------------------
            
            You may create local repository on your project

            For example if you have lib folder in project structure

            In libs folder you should create directory structure like: /groupId/artifactId/version/artifactId-version.jar

            In your pom.xml you should register repository

            <repository>
                <id>ProjectRepo</id>
                <name>ProjectRepo</name>
                <url>file://${project.basedir}/libs</url>
            </repository>
            and add dependency as usual

            <dependency>
                <groupId>groupId</groupId>
                <artifactId>artifactId</artifactId>
                <version>version</version>
            </dependency>

            for more info refer :  https://web.archive.org/web/20130801071744/http://charlie.cu.cc/2012/06/how-add-external-libraries-maven/
           