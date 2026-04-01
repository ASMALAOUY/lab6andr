package com.example.pizzarecipes.service;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed();
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) INSTANCE = new ProduitService();
        return INSTANCE;
    }

    private void seed() {
        // 1. BARBECUED CHICKEN PIZZA
        data.add(new Produit(
                "BARBECUED CHICKEN PIZZA", 3.0, R.drawable.pizza1, "35 min",
                "- 2 chicken breasts\n- 1 cup BBQ sauce\n- Red onion\n- Mozzarella\n- Cilantro",
                "Pizza au poulet barbecue simple et rapide.",
                "1. Griller le poulet\n2. Garnir et cuire 15 min à 220°C"
        ));

        // 2. SPINACH PIZZA
        data.add(new Produit(
                "SPINACH PIZZA", 2.0, R.drawable.pizza2, "25 min",
                "- Alfredo sauce\n- Fresh spinach\n- Cherry tomatoes\n- Mozzarella",
                "Pizza crémeuse et légère aux épinards.",
                "1. Étaler la pâte\n2. Ajouter garniture\n3. Cuire 12 min à 200°C"
        ));

        // 3. MARGHERITA
        data.add(new Produit(
                "MARGHERITA", 1.5, R.drawable.pizza3, "20 min",
                "- Tomato sauce\n- Fresh mozzarella\n- Basil\n- Olive oil",
                "La classique italienne, simple et savoureuse.",
                "1. Sauce tomate\n2. Mozzarella\n3. Cuire 10 min à 250°C\n4. Ajouter basilic frais"
        ));

        // 4. QUATRE FROMAGES
        data.add(new Produit(
                "QUATRE FROMAGES", 2.5, R.drawable.pizza4, "22 min",
                "- Mozzarella\n- Gorgonzola\n- Parmesan\n- Goat cheese\n- Crème fraîche",
                "Un mélange irrésistible de fromages fondants.",
                "1. Crème fraîche sur la pâte\n2. Ajouter les 4 fromages\n3. Cuire 12 min à 220°C"
        ));

        // 5. VÉGÉTARIENNE
        data.add(new Produit(
                "VEGETARIAN PIZZA", 2.2, R.drawable.pizza5, "28 min",
                "- Zucchini\n- Bell pepper\n- Red onion\n- Mushrooms\n- Olives\n- Oregano",
                "Pizza colorée aux légumes frais.",
                "1. Sauce tomate\n2. Disposer les légumes\n3. Cuire 15 min à 210°C"
        ));

        // 6. PEPPERONI
        data.add(new Produit(
                "PEPPERONI PIZZA", 2.8, R.drawable.pizza6, "20 min",
                "- Pepperoni slices\n- Tomato sauce\n- Mozzarella\n- Oregano",
                "Un grand classique au pepperoni croustillant.",
                "1. Sauce tomate\n2. Pepperoni et fromage\n3. Cuire 12 min à 230°C"
        ));

        // 7. HAWAIIAN
        data.add(new Produit(
                "HAWAIIAN PIZZA", 2.5, R.drawable.pizza7, "22 min",
                "- Ham\n- Pineapple chunks\n- Mozzarella\n- Tomato sauce",
                "Le mélange sucré-salé adoré de tous.",
                "1. Sauce tomate\n2. Jambon, ananas, fromage\n3. Cuire 12 min à 220°C"
        ));

        // 8. MEXICANA
        data.add(new Produit(
                "MEXICANA PIZZA", 2.9, R.drawable.pizza8, "30 min",
                "- Ground beef\n- Jalapeños\n- Red beans\n- Corn\n- Salsa sauce\n- Cheddar",
                "Pizza épicée aux saveurs mexicaines.",
                "1. Sauce salsa\n2. Viande, jalapeños, haricots\n3. Fromage cheddar\n4. Cuire 15 min à 210°C"
        ));

        // 9. SEAFOOD PIZZA
        data.add(new Produit(
                "SEAFOOD PIZZA", 3.5, R.drawable.pizza9, "25 min",
                "- Shrimp\n- Calamari\n- Mussels\n- Garlic sauce\n- Parsley",
                "Pizza aux fruits de mer, légère et raffinée.",
                "1. Sauce à l'ail\n2. Fruits de mer\n3. Cuire 12 min à 220°C\n4. Parsemer de persil"
        ));

        // 10. TRUFFLE PIZZA
        data.add(new Produit(
                "TRUFFLE PIZZA", 4.0, R.drawable.pizza10, "20 min",
                "- Truffle cream\n- Mushrooms\n- Mozzarella\n- Parmesan\n- Arugula",
                "Pizza luxueuse à la crème de truffe.",
                "1. Crème de truffe\n2. Champignons et fromages\n3. Cuire 10 min à 240°C\n4. Ajouter roquette après cuisson"
        ));
    }

    @Override
    public Produit create(Produit p) {
        data.add(p);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(x -> x.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(data);
    }
}