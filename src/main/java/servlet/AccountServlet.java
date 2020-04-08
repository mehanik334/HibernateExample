package servlet;

import com.google.gson.Gson;
import model.Account;
import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AccountServlet" , urlPatterns = "api/v1/accounts")
public class AccountServlet extends HttpServlet {

    private AccountService accountService = new AccountService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String id =req.getParameter("id");
        if(id == null) {
            List<Account> list = accountService.getAllAccounts();
            printWriter.write(gson.toJson(list));
        }else {
            Long idAccount = Long.valueOf(id);
            Account account = accountService.findAccount(idAccount);
            printWriter.write(gson.toJson(account));
        }

        printWriter.flush();
    }
}
