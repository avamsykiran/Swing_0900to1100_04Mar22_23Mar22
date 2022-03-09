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
                    FlowLayout          is the defualt layout of JPanel
                    BorderLayout        is the default layout of JFrame and JDialog                    
                    GridLayout
                    BoxLayout                    
                    GridBagLayout
                    CardLayout
                        ...etc

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

        