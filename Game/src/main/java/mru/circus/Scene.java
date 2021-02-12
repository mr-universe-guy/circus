/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus;

import com.jme3.scene.Node;

/**
 *
 * @author Matt
 */
public class Scene {
    private final Node rootNode;
    private final Node guiNode;

    public Scene(Node rootNode, Node guiNode) {
        this.rootNode = rootNode;
        this.guiNode = guiNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public Node getGuiNode() {
        return guiNode;
    }
}
