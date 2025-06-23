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
    
    // 仮のデータ：実際はDBから取得する想定
    static Timestamp ts = Timestamp.valueOf("2020-01-01 10:10:10");
    private static final List<Flower> itemList = Arrays.asList(
        new Flower(1, "rose", 1, ts),
        new Flower(2, "tulip", 2, ts),
        new Flower(3, "sunflower", 3, ts)
    );

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータからIDを取得
        String idParam = request.getParameter("id");
        int id = -1;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "不正なIDです");
            return;
        }

        // 該当するアイテムを探す
        Flower selectedItem = null;
        for (Flower flower : itemList) {
            if (flower.getId() == id) {
                selectedItem = flower;
                break;
            }
        }

        if (selectedItem == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "指定されたアイテムが見つかりません");
            return;
        }

        // JSPに渡して表示
        request.setAttribute("planter", selectedItem);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
