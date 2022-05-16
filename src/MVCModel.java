import java.io.*;

public class MVCModel {

    Rezeptverwaltung rezeptverwaltung;
    Zutatenverwaltung zutatenverwaltung;

    public MVCModel(){

        init; // () fehlt oder alternativ ein Datentyp
    }

    public void init(){

        rezeptverwaltung = new Rezeptverwaltung();
        zutatenverwaltung = new Zutatenverwaltung();
        System.out.println("Initialisieren des Datenmodells abgeschlossen");
    }

    public void speichern(){

        try {
            FileWriter fileWriterRezepte = new FileWriter("Rezepte.txt");
            FileWriter fileWriterZutaten = new FileWriter("Zutaten.txt");
            BufferedWriter bufferedWriterRezepte = new BufferedWriter(fileWriterRezepte);
            BufferedWriter bufferedWriterZutaten = new BufferedWriter(fileWriterZutaten);

            String zutat="";
            for (int i = 0; i < zutatenverwaltung.getIndex(); i++){
                if (zutatenverwaltung.getZutaten()[i] != null;){ // ; zu viel
                    zutat = zutatenverwaltung.getZutaten()[i].getName + ";" + zutatenverwaltung.getZutaten()[i].getPreis(); //() fehlt bei getName
                    bufferedWriterZutaten.write(zutat);
                    bufferedWriterZutaten.newLine();
                }
            }
            bufferedWriterZutaten.close();
            String rezept="";
            String zutaten="";
            for (int i = 0; i < rezeptverwaltung.getIndex() + 1){ //; fehlt; i++ technisch nicht erforderlich, ohne entsteht eine Endlosschleife
                if (rezeptverwaltung.getRezepte()[i] != null){
                    switch(rezeptverwaltung.getRezepte()[i].getTyp()){
                        case "Cocktail":
                            Cocktail cocktail = (Cocktail)rezeptverwaltung.getRezepte()[i];
                            rezept = cocktail.name + ";" + cocktail.isHeißGetraenk() + ";" // cocktail.name nicht möglich, getName() erforderlich
                                    + cocktail.isZuckerfrei() + ";" + cocktail.getAlkohlgehalt() + ";" + cocktail.isAlkohlfrei() + ";"
                                    + cocktail.getTyp();
                            System.out.println("Cocktail gespeichert: " + rezept);
                            break //; fehlt
                        case "Limonade":
                            Limonade Limonade = (Limonade)rezeptverwaltung.getRezepte()[i];
                            rezept = Limonade.name + ";" + Limonade.isHeißGetraenk() + ";" + Limonade.isZuckerfrei() + ";" // cocktail.name nicht möglich, getName() erforderlich
                                    + Limonade.getFruchtgeschmack() + ";" Limonade.getHerstellungInHouse() + ";" // + fehlt
                                    + Limonade.getTyp();
                            System.out.println("Limonade gespeichert " + rezept);
                            break;
                        case "FleischGericht":
                            FleischGericht fleischGericht = (FleischGericht)rezeptverwaltung.getRezepte()[]; // Inhalt von [] fehlt. i naheliegend
                            rezept = fleischGericht.getName() + ";" + fleischGericht.isVegan() + ";" + fleischGericht.isVegetarisch() + ";"
                                    + fleischGericht.getFleischsorte() + ";" + fleischGericht.getZielKerntemperatur() + ";"
                                    + fleischGericht.getZubereitungstemperatur() + ";" + fleischGericht.getTyp();
                            System.out.println("Fleischgericht gespeichert " rezept); // + fehlt
                            break;
                        case "PastaGericht" //: fehlt
                            PastaGericht pastaGericht = (PastaGericht)rezeptverwaltung.getRezepte()[i];
                            rezept = pastaGericht.getName() + ";" + pastaGericht.isVegan() + ";" + pastaGericht.isVegetarisch() + ";"
                                    + pastaGericht.getNudelsorte() + ";" + pastaGericht.isVorspeise() + ";"
                                    + pastaGericht.getTyp();
                            System.out.println(rezeptverwaltung.getRezepte()[i].getName());
                            System.out.println("Pastagereicht gespeichert " + rezept);
                            break;
                        default:
                            break;
                    }
                    bufferedWriterRezepte.write(rezept);
                    bufferedWriterRezepte.newLine();
                    for (int j; j < rezeptverwaltung.getRezepte()[i].getZutaten().length; j++){ // j nicht initialisiert
                        if (rezeptverwaltung.getRezepte()[i].getZutaten()[j] != null) {
                            zutaten = zutaten + rezeptverwaltung.getRezepte()[i].getZutaten()[j].getName() + ";";
                        }
                    }
                    write(zutaten); //Objekt fehlt --> bufferedWriterRezept
                    newLine(); //Objekt fehlt --> bufferedWriterRezept
                    zutaten = "";
                }
            }
            bufferedWriterRezepte.close();
        } catch (IOException e){
            System.out.println("Datei nicht gefunden");
        } catch (FileNotFoundException e){ //Exception kann nicht erreicht werden. Muss vor IOException, da FileNotFound von IOException erbt
            System.out.println(e.getMessage());
        }
    }
}