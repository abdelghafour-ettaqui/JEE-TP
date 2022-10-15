package web;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Produit;

import java.io.IOException;
import java.util.List;


public class ControleurServlet extends HttpServlet {
    private IProduitDao metier;

    @Override
    public void init() throws ServletException {
     metier = new ProduitDaoImpl();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String path=req.getServletPath();
        System.out.println("hello world1");
        if(path.equals("/index.php")){
            System.out.println("hello world2");
            req.getRequestDispatcher("produits.jsp").forward(req,res);
        }
        else if(path.equals("/chercher.php")){
            String motCle=req.getParameter("motCle");
            ProduitModel model=new ProduitModel();
            model.setMotCle(motCle);
            List<Produit> produits=metier.produitsParMC("%"+motCle+"%");
            model.setProduits(produits);
            req.setAttribute("model",model);
            req.getRequestDispatcher("produits.jsp").forward(req,res);
        } else if (path.equals("/Saisie.php")) {
            req.setAttribute("produit",new Produit());
            req.getRequestDispatcher("SaisieProduit.jsp").forward(req,res);
            
        }
        else if (path.equals("/SaveProduit.php")&&(req.getMethod().equals("Post"))){
            String des=req.getParameter("designation");
            double prix=Double.parseDouble(req.getParameter("prix"));
            int quantite=Integer.parseInt(req.getParameter("quantite"));
            Produit p = metier.save(new Produit(des,prix,quantite));
            req.setAttribute("produit",p);
            req.getRequestDispatcher("Confirmation.jsp").forward(req,res);

        }
        else if(path.equals("/Supprime.php")){
            Long id=Long.parseLong(req.getParameter("id"));
            metier.deleteProduit(id);
           // req.getRequestDispatcher("produits.jsp").forward(req,res);
            res.sendRedirect("chercher.php?motCle=");
        }
        else if (path.equals("/Edit.php")) {
            Long id = Long.parseLong(req.getParameter("id"));
            Produit p = metier.getProduit(id);
            req.getRequestDispatcher("EditProduit.jsp").forward(req,res);

        }
        else if (path.equals("/UpdateProduit.php")&&(req.getMethod().equals("Post"))){
            Long id=Long.parseLong(req.getParameter("id"));
            System.out.println(id);
            String des=req.getParameter("designation");
            System.out.println(des);
            double prix=Double.parseDouble(req.getParameter("prix"));
            System.out.println(prix);
            int quantite=Integer.parseInt(req.getParameter("quantite"));
            System.out.println(quantite);
            Produit p = new Produit(des,prix,quantite);
            p.setId(id);
            metier.update(p);
            req.setAttribute("produit",p);
            req.getRequestDispatcher("Confirmation.jsp").forward(req,res);


        }
        else{
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet((HttpServletRequest) res, (HttpServletResponse) req);
    }
}
