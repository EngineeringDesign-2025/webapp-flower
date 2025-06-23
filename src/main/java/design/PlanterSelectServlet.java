package design;

import design.Flower;
import design.FlowerDAO;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class PlanterSelectServlet
 */
@WebServlet("/PlanterSelectServlet")
public class PlanterSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanterSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
    // 仮のデータ：実際はDBから取得する想定
    static Timestamp ts = Timestamp.valueOf("2020-01-01 10:10:10");
    private static final List<Flower> itemList = Arrays.asList(
        new Flower(1, "rose", 1, ts),
        new Flower(2, "tulip", 2, ts),
        new Flower(3, "sunflower", 3, ts)
    );
    */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");

        if (idStr == null || idStr.isEmpty()) {
            // IDが無ければ一覧画面にリダイレクト
            response.sendRedirect("planterList.jsp");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            // 数値変換できなければ一覧に戻す
            response.sendRedirect("planterList.jsp");
            return;
        }

        // DAOを使って花を取得
        Flower flower = FlowerDAO.getFlowerById(id);

        if (flower == null) {
            // 見つからなければ一覧に戻す
            response.sendRedirect("flowerList.jsp");
            return;
        }

        // 例として、levelが0なら種選択画面、そうでなければ水やり画面に遷移
        if (flower.getLevel() == 0) {
            // 種選択画面へ
            request.setAttribute("flower", flower);
            request.getRequestDispatcher("seedSelect.jsp").forward(request, response);
        } else {
            // 水やり画面へ
            request.setAttribute("flower", flower);
            request.getRequestDispatcher("watering.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
