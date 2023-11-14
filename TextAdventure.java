import java.util.Scanner;
public class TextAdventure {
	private static String planet;
	private static String ship;
	private static int speed = 0;
	private static int attack = 0;
	private static boolean crystal = false;
	private static boolean card = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		game(sc);
		sc.close();
	}
	private static void game(Scanner sc) {
		System.out.println("\nIn the year 2180, humans have colonised most of the habitable planets in the galaxy.\nYou are a scientist on the planet Taliga, tasked with finding the precise location of the planet Caprian and bringing back a sample of soil to gauge the development of some of the basic lifeforms present on it.\nCaprian is surrounded by hostile alien races that dominate the vast volumes of space around it.\n\nBefore you set off, The Institute offers you a choice between two ships:\n1. The Stallion -> Known for it's speed, it can be useful when in pursuit or in time-sensitive situations.\n2. The Golem -> A larger ship with a weapons system, more likely to stay and fight than to evade danger.");
		while (true) {
			System.out.print("Which one do you choose? ");
			String choice = sc.nextLine();
			if (choice.equals("1")) {
				ship = "Stallion";
				speed = 70;
				attack = 30;
				break;
			} else if (choice.equals("2")) {
				ship = "Golem";
				speed = 30;
				attack = 70;
				break;
			} else {
				System.out.println("Invalid choice.");
			}
		}
		System.out.println("\nAnd with that, you embark upon your journey.");
		wait(2000);
		taliga(sc);
	}
	private static void taliga(Scanner sc) {
		planet = "Taliga";
		System.out.println("\nOn your radar, you spot two planetary systems close to Taliga:\n1. Soldino\n2. Beet Classic\nFurthermore, you could try your luck elsewhere:\n3. The Taliga System Asteroid Belt.");
		while (true) {
			System.out.print("\nWhere do you wish to go? ");
			String choice = sc.nextLine();
			if (choice.equals("1")) {
				wait(2000);
				soldino(sc);
				break;
			} else if (choice.equals("2")) {
				wait(2000);
				beetClassic(sc);
				break;
			} else if (choice.equals("3")) {
				wait(2000);
				asteroidBelt(sc);
				break;
			} else {
				System.out.println("Invalid choice.");
			}
		}
	}
	private static void soldino(Scanner sc) {
		planet = "Soldino";
		System.out.println("\nYou warp to the Soldino system.\nThe largest planet Forlore is a toxic wasteland, but its moon Soldino has one of the best stations in the galaxy.\n\nYou decide to take a small break and wander the markets at the dock.\nAs you walk around, you come across a small shop selling Bicarizzian crystals.\nThey might come in handy if you ever need raw extracts of fuel.\n1. Buy a crystal\n2. Leave");
		while (true) {
			System.out.print("What do you want to do? ");
			String choice = sc.nextLine();
			if (choice.equals("1")) {
				System.out.println("\nYou bought a crystal.");
				crystal = true;
				break;
			} else if (choice.equals("2")) {
				System.out.println("\nYou left.");
				crystal = false;
				break;
			} else {
				System.out.println("Invalid choice.");
			}
		}
		System.out.println("\nYour work here is done. You immediately take leave in your ship.\nUnfortunately, there are no known systems beyond Soldino.\nThis means that you must venture into unknown territory if you want to find Caprian.");
		wait(3000);
		battle(sc, planet);
	}
	private static void beetClassic(Scanner sc) {
		planet = "Beet Classic";
		System.out.println("\nYou warp to the Beet system and arrive at Beet Classic, a bustling port.\nWhile exploring the market district, you stumble upon a hidden alleyway.\nCuriosity piques your interest, and you decide to investigate further.\nIn the dimly lit alley, you find an old bookshop. It is filled with ancient artifacts.\nNo one seems to be around at the moment.\n\nSo you pick up a few books, looking at what they contain.\nThey are written in languages you can not understand.\nOne by one, you ruffle the pages of the books to find something interesting.\nSuddenly, you come across a folded page and unfold it.\nIn the center of the page lies a bright red card with markings on it.\nYou have a vague memory of a galaxy-wide portal rumored to require a red key of some sort.\nCould it be this card?\n1. Take the card\n2. Leave");
		while (true) {
			System.out.print("What do you want to do? ");
			String choice = sc.nextLine();
			if (choice.equals("1")) {
				System.out.println("\nYou took the card.");
				card = true;
				break;
			} else if (choice.equals("2")) {
				System.out.println("\nYou left.");
				card = false;
				break;
			} else {
				System.out.println("Invalid choice.");
			}
		}
		System.out.println("\nTime to keep going. It's better not to arouse suspicion if the card is important.\n\nYou continue trying to find Caprian, but Beet Classic does not have any good directories of the galaxy.\nYou realize you might have to travel to Beet Antheros, a planet on the other side of the system, to get a better understanding of where Caprian might be.\n\nUnfortunately, Beet Antheros does not allow personal ships to enter their station.\nYou must catch a ferry from Beet Classic. Luckily, a ferry is just leaving.\nYou get on it, hoping you're at least a little closer to finding Caprian.");
		wait(8000);
		ferry(sc);
	}
	private static void ferry(Scanner sc) {
		speed = 40;
		attack = 40;
		if (random(100) <= 30) {
	        battle(sc, planet);
		} else {
			beetAntheros(sc);
		}
	}
	private static void beetAntheros(Scanner sc) {
		System.out.println("\nAs you approach the planet, you can already see the tallest buildings through the atmosphere.\nBeet Antheros is known for its technological advancement, and is hence safeguarded by a strong militia.\n\nFinally, you land and try to find a good directory.\nThe port has a huge display showing nearby planets and star systems. Caprian is not one of them.\nDejected and walking along the cold, neon-lit streets of the port, you catch a glimpse of a large, leathery red door guarded by a burly alien.\nIt could have something to do with that portal you've heard about.\n\nYou attempt to negotiate with the guard.");
		if (card) {
			wait(10000);
       		System.out.println("\nYou have the red card with you. The guard lets you in.");
       		portal(sc);
		} else {
			int negotiateChance = random(100);
			if (negotiateChance <= 40) {
        		wait(10000);
        		System.out.println("Your negotiation skills impressed the guard. They give you a red card and let you inside.");
				card = true;
        		portal(sc);
			} else {
        		wait(10000);
				System.out.println("The guard is not convinced. You cannot enter.\nWasting your time on a planet far from home, you are already behind schedule.\nBetter luck next time!\n\nGame over.");
			}
		}
	}
	private static void portal(Scanner sc) {
		System.out.println("\nYou enter the building through the big red door and are shocked by the bright colors that swim across the hallway.\nYou have never seen sights like these before.\nThe whole place is filled with various semi-organic creatures and machines that seem to have a mind of their own.\nYou rush towards the end of the hallway.\n\nIn front of you stands a door with the word PORTAL engraved on it.\nGreat, just what you needed.\nAn assistant approaches you, asking you where you want to go.\nYou already know your answer.\nThe assistant takes your red card and inserts it into a slot next to the door, opening it in the process.\n\nThe portal hums to life, and a swirling vortex of energy appears before you.\nYou step right through it.");
		wait(12000);
		caprian(sc);
	}
	private static void asteroidBelt(Scanner sc) {
		planet = "Asteroid";
		System.out.println("\nYou navigate your ship through the dense Taliga Asteroid Belt, a treacherous region filled with space debris.\nWhile exploring the asteroids, you stumble upon one with a hidden cache.");
		int randomEvent = random(100);
		if (randomEvent <= 30 && !crystal) {
			System.out.println("\nYou found a Bicarizzian crystal. This could come in handy for fueling your ship.");
			crystal = true;
		} else if (randomEvent <= 40) {
			System.out.println("\nThere's nothing here.");
		} else if (randomEvent <= 60 && !card) {
			System.out.println("\nYou found a red card with strange markings on it.\nYou remember a rumor about a portal that requires a red key.");
			card = true;
		} else if (randomEvent <= 75) {
			wait(2000);
			battle(sc, planet);
			return;
		} else if (randomEvent <= 90) {
			System.out.println("\nThe ship is nearly hit by a smaller asteroid. You frantically increase speed, crossing the belt.\nYou have entered a clearing. You decide to warp to the nearest star system, the Beet system.\nThere, you can land on the planet Beet Antheros.");
			wait(3000);
			beetAntheros(sc);
			return;
		} else {
			System.out.println("\nAs you approach the large asteroid, a smaller asteroid crashes into your ship.\nYou have no way to escape this maze now.\n\nGame over.");
			return;
		}
		System.out.println("\n1. Continue exploring the Taliga Asteroid Belt\n2. Leave the Taliga Asteroid Belt");
		while (true) {
			System.out.print("\nWhat do you wish to do? ");
			String choice = sc.nextLine();
			if (choice.equals("1")) {
				wait(2000);
				asteroidBelt(sc);
				break;
			} else if (choice.equals("2")) {
				randomEvent = random(100);
				if (randomEvent <= 60) {
					wait(2000);
					neodome(sc);
				} else if (randomEvent <= 80) {
					wait(2000);
					beetAntheros(sc);
				} else if (randomEvent <= 90) {
					wait(2000);
					battle(sc, planet);
				} else {
					System.out.println("\nAs you attempt to maneuver the ship through the increasingly narrowing spaces of the asteroid belt, a smaller asteroid crashes into it.\nYou have no way to escape this maze now.\n\nGame over.");
				}
				break;
			} else {
				System.out.println("Invalid choice.");
			}
		}
	}
	private static void neodome(Scanner sc) {
		planet = "Neodome";
		System.out.println("\nYou warp to the Neodome system. Neodome is a planet known for its giant landmasses and rich ores, thus making it the primary location for a ship factory.\nYou land on the planet amidst a bleak brown and grey landscape.\n\nTrying to make yourself at home, you cannot forget your mission.\nYou walk along the various exhibits and shops until something catches your eye: a large board that offers premium rides to Caprian, your destination!\nBut here's the catch - the price is one Bicarizzian crystal.\nRight next to it is a store that promises modifications to your own ship, making it 3 times as fast and also upgrade the weapons system.\nHowever, you must trade a portal card with them.");
		if (crystal && card) {
			System.out.println("\nYou have both those things, assuming the red card you have is the one that they want.\n1. Take the ride\n2. Get modifications done");
			while (true) {
				System.out.print("What do you wish to do? ");
				String choice = sc.nextLine();
				if (choice.equals("1")) {
					System.out.println("\nYou hand over the crystal and get on the transport. It takes off.");
					crystal = false;
					attack *= 3;
					if (random(100) <= 30) {
						wait(8000);
						battle(sc, planet);
					} else {
						System.out.println("\nYour ship was so intimidating that alien ships turned away to avoid it. Awesome!");
						wait(8000);
						caprian(sc);
					}
					break;
				} else if (choice.equals("2")) {
					System.out.println("\nYou hand them the card, hoping it's the one they're looking for.\nBingo! You're booked.\n\nNow, your ship is fitted with boosters that make it a lot faster than before. This can come in handy.\nWith this, you decide to head out.");
					card = false;
					speed *= 3;
					attack *= 2;
					if (random(100) <= 30) {
						wait(8000);
						battle(sc, planet);
					} else {
						System.out.println("\nYou warped so quickly that you couldn't even see the stars. Awesome!");
						wait(8000);
						caprian(sc);
					}
					break;
				} else {
					System.out.println("Invalid choice.");
				}
			}
		} else if (crystal) {
			System.out.println("\nLuckily, you picked up a crystal of that kind earlier.\nYou hand it over and get on the ferry. The ferry takes off.");
			crystal = false;
			wait(2000);
			ferry(sc);
		} else if (card) {
			System.out.println("\nYou don't have the crystal, but you do have a red card.\nYou hand them the card, hoping it's the one they're looking for.\nBingo! You're booked.\n\nNow, your ship is fitted with boosters that make it a lot faster than before. This can come in handy.\nWith this, you decide to head out.");
			card = false;
			speed *= 3;
			attack *= 2;
			if (random(100) <= 30) {
				wait(4000);
				battle(sc, planet);
			} else {
				System.out.println("\nYou warped so quickly that you couldn't even see the stars. Awesome!");
				wait(4000);
				caprian(sc);
			}
		} else {
			System.out.println("You don't have either of those things. But if there's a direct ride to Caprian, maybe you could try to get there on your own.\nYou decide to venture out.");
			if (random(100) <= 70) {
				wait(3000);
				battle(sc, planet);
			} else {
				wait(3000);
				caprian(sc);
			}
		}
	}
	private static void caprian(Scanner sc) {
		System.out.println("\nYou arrive at Caprian, the planet you were tasked to explore.\nThe planet's surface is covered in lush forests and exotic flora.\nYou set up your equipment and collect soil samples from various locations.\nYou manage to gather valuable data.\n\nCongratulations! You have successfully completed your mission on Caprian.");
		if (card) {
			System.out.println("\nYou still have your red card and the portal is where it was before, ensuring your safe return.");
		}
		System.out.println("\nGame over.");
	}
	private static void battle(Scanner sc, String planet) {
		int enemyAttack = random(50);
		int enemyEvade = random(50);
		int playerHealth = 100;
		int enemyHealth = 100;
		boolean crystalValuable = true;
		boolean cardValuable = true;
		System.out.println("\nYou are ambushed by a hostile alien ship!");
		while (playerHealth > 0 && enemyHealth > 0) {
			System.out.println("\nYour ship's health: " + playerHealth);
			System.out.println("Enemy ship's health: " + enemyHealth);
			System.out.print("\n1. Attack\n2. Evade\n3. Negotiate\nWhat do you want to do? ");
			String choice = sc.nextLine();
			if (choice.equals("1")) {
				int damageDealt = random(attack);
				enemyHealth -= damageDealt;
				System.out.println("You dealt " + damageDealt + " damage to the enemy!");
			} else if (choice.equals("2")) {
				int evadeChance = random(speed);
		        if (evadeChance > enemyEvade) {
		            System.out.println("You managed to escape from the battle!");
		            break;
		        } else {
		            System.out.println("The enemy ship is faster. They caught up with you and attacked!");
		            int enemyDamage = random(enemyAttack);
		            playerHealth -= enemyDamage;
		            System.out.println("The enemy dealt " + enemyDamage + " damage to you!");
		        }
		    } else if (choice.equals("3")) {
		        if (crystal && crystalValuable) {
		            int tradeChance = random(100);
		            if (tradeChance <= 40) {
		                System.out.println("You successfully used the crystal to negotiate with the aliens. They let you go unharmed.");
		                crystal = false;
		                break;
		            } else {
		                System.out.println("The aliens didn't find the crystal valuable. They attack!");
		                crystalValuable = false;
		                continue;
		            }
				}
		        if (card && cardValuable) {
		            int tradeChance = random(100);
		            if (tradeChance <= 60) {
		                System.out.println("You successfully used the red card to negotiate with the aliens. They let you go unharmed.");
		                card = false;
		                break;
		            } else {
		                System.out.println("The aliens didn't find the red card valuable. They attack!");
		                cardValuable = false;
		                continue;
		            }
		        } else {
		            int negotiateChance = random(100);
		            if (negotiateChance <= 20) {
		                System.out.println("Your negotiation skills impressed the aliens. They let you go unharmed.");
		                break;
		            } else {
		                System.out.println("The aliens were not convinced. They attack!");
		            }
		        }
		        int enemyDamage = random(enemyAttack);
		        playerHealth -= enemyDamage;
		        System.out.println("The enemy dealt " + enemyDamage + " damage to you!");
		    } else {
		        System.out.println("Invalid choice. You hesitate and the enemy attacks!");
		        int enemyDamage = random(enemyAttack);
		        playerHealth -= enemyDamage;
		        System.out.println("The enemy dealt " + enemyDamage + " damage to you!");
		    }
		}
		if (playerHealth <= 0) {
		    System.out.println("\nYou were defeated by the hostile alien ship.\n\nGame over.");
		} else {
		    System.out.println("\nYou defeated the hostile alien ship! Congratulations!");
		    if (planet.equals("Soldino")) {
			    wait(2000);
				caprian(sc);
		    } else if (planet.equals("Beet Classic")) {
			    wait(2000);
				beetAntheros(sc);
		    } else if (planet.equals("Asteroid")) {
			    wait(2000);
				neodome(sc);
		    } else if (planet.equals("Neodome")) {
			    wait(2000);
				caprian(sc);
		    }
		}
	}
	private static int random(int n) {
		double number = 1 + (Math.random() * n);
		return (int)number;
	}
	private static void wait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
