package com.polytech;

import com.polytech.tp.*;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Démonstration des Design Patterns ===\n");

        // ===== Pattern Builder =====
        System.out.println("1. Pattern Builder - Construction fluide d'un cours:");
        Cours cours1 = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("Prof. Martin")
                .setSalle("A101")
                .setDate("2025-11-25")
                .setHeureDebut("10:00")
                .setEstOptionnel(false)
                .setNiveau("M1")
                .setNecessiteProjecteur(true)
                .build();

        System.out.println("Cours créé : " + cours1.getDescription());
        System.out.println();

        // ===== Pattern Observer =====
        System.out.println("2. Pattern Observer - Notification des changements:");
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();

        // Créer des observateurs
        Etudiant etudiant1 = new Etudiant("Alice");
        Etudiant etudiant2 = new Etudiant("Bob");
        Responsable responsable = new Responsable("M. Dupont");

        // S'abonner aux notifications
        gestionnaire.attach(etudiant1);
        gestionnaire.attach(etudiant2);
        gestionnaire.attach(responsable);

        // Ajouter un cours (déclenche les notifications)
        gestionnaire.ajouterCours(cours1);
        System.out.println();

        // Modifier un cours
        gestionnaire.modifierCours(cours1, "Le cours de Génie Logiciel est déplacé en salle B202");
        System.out.println();

        // ===== Pattern Decorator =====
        System.out.println("3. Pattern Decorator - Extension dynamique des fonctionnalités:");

        // Cours de base
        Cours cours2 = new CoursBuilder()
                .setMatiere("Algorithmique")
                .setEnseignant("Prof. Smith")
                .setSalle("B303")
                .build();

        System.out.println("Cours de base : " + cours2.getDescription());
        System.out.println("Durée : " + cours2.getDuree() + "h");

        // Décorer avec "En ligne"
        ICours coursEnLigne = new CoursEnLigne(cours2);
        System.out.println("\nAvec décorateur En ligne : " + coursEnLigne.getDescription());

        // Décorer avec plusieurs décorateurs (combinaison)
        ICours coursEnLigneAnglais = new CoursEnAnglais(new CoursEnLigne(cours2));
        System.out.println("Avec deux décorateurs : " + coursEnLigneAnglais.getDescription());

        // Cours magistral (modifie aussi la durée)
        ICours coursMagistral = new CoursMagistral(cours2);
        System.out.println("\nCours Magistral : " + coursMagistral.getDescription());
        System.out.println("Durée modifiée : " + coursMagistral.getDuree() + "h");

        System.out.println("\n=== Fin de la démonstration ===");
    }
}