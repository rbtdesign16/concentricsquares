
package org.rbt.concentricsquares;

import java.io.PrintWriter;

public class ConcentricSquares {
    private static final String[] SQUARE_COLOR = {"crimson"};
    private static final Integer CANVAS_SIZE = 600;
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
            pw.println("\t<canvas id='sp' height='" 
                + CANVAS_SIZE + "' width='"
                + CANVAS_SIZE + "' style='background: white; border:1px solid darkgray;'></canvas>'"); 
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
            pw.println("\tconst CANVAS_SIZE = " + CANVAS_SIZE + ";");
            pw.println("\tconst centerX = " + (CANVAS_SIZE / 2) + ";");
            pw.println("\tconst centerY = " + (CANVAS_SIZE / 2) + ";");
            pw.println("\tasync function doGraph() {");
            pw.println("\t\tlet c=document.getElementById('sp');");
            pw.println("\t\tlet ctx=c.getContext('2d');");
            pw.println("\t\tctx.strokeStyle = 'black';");
            pw.println("\t\tctx.lineWidth = 1;");
            pw.println("// axis lines");
            pw.println("\t\tctx.beginPath();");
            pw.println("\t\tctx.lineWidth = 2;");
            pw.println("\t\tctx.moveTo(0, centerY);");
            pw.println("\t\tctx.lineTo(CANVAS_SIZE, centerY);");
            pw.println("\t\tctx.moveTo(centerX, 0);");
            pw.println("\t\tctx.lineTo(centerX, CANVAS_SIZE)");
            pw.println("\t\tctx.stroke();");
            pw.println("\t}");
 
            /*
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
*/
            pw.println("\t");
            pw.println("</script>");
            pw.println();
    }

}
