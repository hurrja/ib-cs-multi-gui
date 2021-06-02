// Copyright (C) 2021 Jarmo Hurri

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// gui extends frame and inherits all its methods (e.g., for setting
// size, adding components)

public class GUI extends JFrame
{
  // constructor will create all GUI components and set their properties
  public GUI ()
  {
    super ("A multi-panel / multi-frame demo");

    // frame properties
    setSize (400, 300);
    cardLayout = new CardLayout ();
    setLayout (cardLayout);

    // menu bar with one item for quitting the program
    JMenuBar menuBar = new JMenuBar ();
    JMenu fileMenu = new JMenu ("File");
    JMenuItem newItem = new JMenuItem ("New frame");
    newItem.addActionListener ((ActionEvent e) -> new GUI ());
    JMenuItem nextItem = new JMenuItem ("Next panel");
    nextItem.addActionListener ((ActionEvent e) -> (cardLayout.next (getContentPane ())));
    JMenuItem quitItem = new JMenuItem ("Quit");
    quitItem.addActionListener ((ActionEvent e) -> System.exit (0));
    fileMenu.add (newItem);
    fileMenu.add (nextItem);
    fileMenu.add (quitItem);
    menuBar.add (fileMenu);
    setJMenuBar (menuBar);

    redPanel = new JPanel ();
    redPanel.setBackground (Color.red);
    add (redPanel);
    bluePanel = new JPanel ();
    bluePanel.setBackground (Color.blue);
    add (bluePanel);

    setVisible (true); // show frame
  }

  JPanel redPanel, bluePanel;
  CardLayout cardLayout;
}
