package com.evapps.lightsout.solver;


import com.evapps.lightsout.activity.ActivityGameboard;

import org.ejml.simple.SimpleMatrix;

public class SolverUtils {

    public static SimpleMatrix getAdjacencyMatrix(int numRows, int numCols, ActivityGameboard activityGameboard) {

        SimpleMatrix M = new SimpleMatrix(numRows * numCols, numRows * numCols);
        Solver solver = new Solver(numRows, numCols, activityGameboard);

        int row_count = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double[] vec = solver.getAdjacentPositions(i, j);
                M.setRow(row_count, 0, vec);
                row_count++;
            }
        }
        return M;
    }
}
