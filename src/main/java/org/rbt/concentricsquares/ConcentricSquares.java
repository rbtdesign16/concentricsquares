
package org.rbt.concentricsquares;

import java.io.PrintWriter;

public class ConcentricSquares {
    private static final int CANVAS_SIZE = 23000;
    private static final int CANVAS_ZOOM = 3;
    private static final Integer SCALING_DENOMINATOR = 4000;
    private static final String[] LINE_COLORS = {"cornsilk", "cyan", "goldenrod"};
    private static final String[] LINE_ALPHA = {"0.1", "0.1", "0.02"};
    private static final String CANVAS_BACK_COLOR = "black";
    private static final String OUTPUT_FILE = "/Users/rbtuc/Desktop/con-squares.html";

    
    public static void main(String[] args) {
        printHtml();
    }

    private static void printHtml() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(OUTPUT_FILE);
            pw.println("<html>");
            printScriptTag(pw);
            pw.println("<body>");
            pw.println("\t<canvas id='sp' width='" 
                + CANVAS_SIZE  
                + "' height='" 
                + CANVAS_SIZE 
                + "' style='border:1px solid darkgray; background-color: " 
                + CANVAS_BACK_COLOR
                + "; zoom: " 
                + CANVAS_ZOOM + "%'></canvas>");
            pw.println("\t<script type='text/javascript'>setTimeout(1000, doGraph())</script>");
            pw.println("</body></html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                pw.close();
            } catch (Exception ex) {
            };
        }
    }
    private static void printScriptTag(PrintWriter pw) throws Exception {
            pw.println("<script type='text/javascript'>");
    
            
            pw.println("\tconst PLOT_LINE_COLOR = 'LightGoldenrodYellow';");
            pw.println("\tconst BACKGROUND_COLOR = 'black';");
            pw.println("\tconst gridScale = 500000;");
            pw.println("\tconst AXIS_COLOR = 'firebrick';");
            pw.println("\tconst CONCENTRIC_RING_COLOR = 'CornflowerBlue';");
            pw.println("\tconst DEFAULT_ALPHA = 0.015;");
            pw.println("\tconst DEFAULT_LINE_WIDTH = 25;");
            pw.println("\tconst SCALING_FACTOR  = Math.PI / " + SCALING_DENOMINATOR + ";");
            pw.println("\tconst centerX = " + (CANVAS_SIZE / 2) + ";");
            pw.println("\tconst centerY = " + (CANVAS_SIZE / 2) + ";");
            pw.println("\tconst GRAPH_LINE_VALUES = [1000000, 5000000, 10000000, 15000000];");
            pw.println("let imgindx = 1;");
            pw.println();
            
            pw.println("\tasync function doGraph() {");
            pw.println("\t\tlet c=document.getElementById('sp');");
            pw.println("\t\tlet ctx=c.getContext('2d');");
            pw.println("\t\tctx.strokeStyle = PLOT_LINE_COLOR;");
            pw.println("\t\tctx.globalAlpha = DEFAULT_ALPHA ;");
            pw.println("\t\tctx.lineWidth = 1;");
            pw.println();
            pw.println("\t\t// loop over gap list and prime list to plat display");
            pw.println("\t\t// on circle in polar coordinates - 2 PI cover entire range");
            pw.println("\t\tfor (let gapindx = 0; gapindx < gaps.length; ++gapindx) {");
            pw.println("\t\t\tctx.beginPath();");
            pw.println("\t\t\tctx.moveTo(centerX, centerY);");
            pw.println("\t\t\tfor (let primeindx = 0; primeindx < primes.length; ++primeindx) {");
            pw.println("\t\t\t\tdrawAttractor(ctx, gaps[gapindx], primeindx)");
            pw.println("\t\t\t}");
            pw.println("\t\t\tctx.stroke();");
            pw.println("\t\t}");
            
            pw.println("\t\tctx.stroke();");
            pw.println("\t\t// concentric lines");
            pw.println("\t\tctx.beginPath();");
            pw.println("\t\tctx.globalAlpha = 1.0;");
            pw.println("\t\tctx.lineWidth = DEFAULT_LINE_WIDTH;");
            pw.println("\t\tctx.strokeStyle = CONCENTRIC_RING_COLOR;");
            pw.println("\t\tfor (let i = 0; i < GRAPH_LINE_VALUES.length; ++i) {");
            pw.println("\t\t\tctx.arc(centerX, centerY, SCALING_FACTOR * GRAPH_LINE_VALUES[i], 0, 2 * Math.PI);");
            pw.println("\t\t}");
            pw.println("\t\tctx.stroke();");

            pw.println();
            pw.println("// diagonal lines");
            pw.println("\t\tctx.beginPath();");
            pw.println("\t\tctx.strokeStyle = AXIS_COLOR;");
            pw.println("\t\tctx.moveTo(0, centerY);");
            pw.println("\t\tctx.lineTo(2 * centerX, centerY);");
            pw.println("\t\tctx.moveTo(centerX, 0);");
            pw.println("\t\tctx.lineTo(centerX, 2 * centerY);");
            pw.println("\t\tctx.stroke();");
            pw.println();
            pw.println("// axis lines");
            pw.println("\t\tctx.beginPath();");
            pw.println("\t\tctx.lineWidth = DEFAULT_LINE_WIDTH;");
            pw.println("\t\tctx.moveTo(0, 0);");
            pw.println("\t\tctx.lineTo(" + CANVAS_SIZE + "," + CANVAS_SIZE + ");");
            pw.println("\t\tctx.moveTo(0," + CANVAS_SIZE + ");");
            pw.println("\t\tctx.lineTo(" + CANVAS_SIZE + ",0)");
            pw.println("\t\tctx.stroke();");
            pw.println("\t}");
 
            
            pw.println("\t// draw scaled prime magnited for specified prime gap");
            pw.println("\t// on circle in polar coordinates - 2 PI cover entire range");
            pw.println("\tasync function drawAttractor(ctx, gap, primeindx) {");
            pw.println("\t\tlet diff = primes[primeindx] - primes[primeindx - 1];");
            pw.println("\t\tif (diff == gap) {");
            pw.println("\t\t\tlet theta = primes[primeindx] * SCALING_FACTOR;");
            pw.println("\t\t\tlet x = centerX + theta * Math.cos(theta); ");
            pw.println("\t\t\tlet y = centerY + theta * Math.sin(theta);");
            pw.println("\t\t\tctx.strokeStyle = getLineColor(primes[primeindx]);");
            pw.println("\t\t\tctx.globalAlpha = getLineAlpha(primes[primeindx]);");
            pw.println("\t\t\tctx.lineTo(x, y);");
            //pw.println("ctx.stroke();");
            pw.println("\t\t\tctx.moveTo(centerX, centerY);");
            pw.println("\t\t};");
            pw.println("\t};");
            pw.println();
            pw.println("\tfunction getLineColor(val) {");
            pw.println("\t\tif (val < 5000000) {");
            pw.println("\t\t\treturn '" + LINE_COLORS[0] + "';");
            pw.println("\t\t} else if (val > 10000000) {");
            pw.println("\t\t\treturn '" + LINE_COLORS[2] + "';");
            pw.println("\t\t } else {");
            pw.println("\t\t\treturn '" + LINE_COLORS[1] + "';");
            pw.println("\t\t}");
            pw.println("\t}");
            pw.println();
            pw.println("\tfunction getLineAlpha(ctx, val) {");
            pw.println("\t\tif (val < 5000000) {");
            pw.println("\t\t\treturn " + LINE_ALPHA[0] + ";");
            pw.println("\t\t} else if (val > 10000000) {");
            pw.println("\t\t\treturn " + LINE_ALPHA[2] + ";");
            pw.println("\t\t } else {");
            pw.println("\t\t\treturn " + LINE_ALPHA[1] + ";");
            pw.println("\t\t}");
            pw.println("\t}");

            pw.println("</script>");
            pw.println();
    }

}
