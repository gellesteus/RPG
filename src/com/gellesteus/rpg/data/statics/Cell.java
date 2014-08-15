package com.gellesteus.rpg.data.statics;

import com.badlogic.gdx.math.Vector2;

public class Cell {
/*	All areas that players and NPCs are composed of cells.
 *  A cell is a 1X1 square.
 *  they occupy space from topRightPos to topRightPos+(1,1)
 *  Because each scene is unique, each cell is also unique.
 *  A scene contains one cell which may or may not be linked to other cells.
 *  When they are generated they are tagged as major if they contain neighbours in
 *  different axis and minor if they contain neighbours in only one.
 *  This determines where the waypoints will be placed.
 */
	
	private Cell north,east,south,west;
	private Vector2 topRightPos;
	
	
	
}
