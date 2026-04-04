-- ============================================
-- ENABLE EXTENSION
-- ============================================
CREATE EXTENSION IF NOT EXISTS pgcrypto;

BEGIN;

-- ============================================
-- INSERT CUSTOMERS
-- ============================================
INSERT INTO customer (id, name, email, phone_number, address)
VALUES
(gen_random_uuid(), 'John Doe', '[john@example.com](mailto:john@example.com)', '3001112233', 'Street 10 #22-11'),
(gen_random_uuid(), 'Jane Smith', '[jane@example.com](mailto:jane@example.com)', '3015557788', 'Avenue 5 #44-20'),
(gen_random_uuid(), 'Carlos Ramirez', '[carlos@example.com](mailto:carlos@example.com)', '3024441122', 'Calle 80 #10-30'),
(gen_random_uuid(), 'Laura Torres', '[laura@example.com](mailto:laura@example.com)', '3157778899', 'Carrera 12 #90-10'),
(gen_random_uuid(), 'Ana Martinez', '[ana@example.com](mailto:ana@example.com)', '3102223344', 'Street 7 #11-50');

-- ============================================
-- INSERT PIZZAS (BOOLEAN FIX)
-- ============================================
INSERT INTO pizza (id, name, description, price, available, type)
VALUES
(gen_random_uuid(), 'Margherita', 'Tomato sauce, mozzarella, basil', 25.50, true, 'VEGETARIAN'),
(gen_random_uuid(), 'Four Cheese', 'Mozzarella, parmesan, gorgonzola, cheddar', 32.00, true, 'VEGETARIAN'),
(gen_random_uuid(), 'Veggie Supreme', 'Bell peppers, olives, onions, mushrooms', 27.00, true, 'VEGETARIAN'),
(gen_random_uuid(), 'Spinach Alfredo', 'Creamy alfredo sauce with spinach', 28.50, true, 'VEGETARIAN'),
(gen_random_uuid(), 'Vegan Delight', 'Plant-based cheese and vegetables', 30.00, true, 'VEGAN'),
(gen_random_uuid(), 'Vegan BBQ', 'BBQ sauce with vegan protein and onions', 31.50, true, 'VEGAN'),
(gen_random_uuid(), 'Green Garden', 'Zucchini, spinach, vegan cheese', 29.00, true, 'VEGAN');

-- ============================================
-- INSERT ORDERS
-- ============================================
INSERT INTO pizza_order (id, additional_notes, date, id_customer, method, total)
SELECT
gen_random_uuid(),
'No onions please',
NOW() - (random() * INTERVAL '10 days'),
c.id,
CASE WHEN random() > 0.5 THEN 'D' ELSE 'P' END,
0
FROM customer c
LIMIT 5;

-- ============================================
-- INSERT ORDER ITEMS
-- ============================================
INSERT INTO order_item (id, id_order, id_pizza, price, quantity)
SELECT
gen_random_uuid(),
o.id,
p.id,
p.price,
(1 + floor(random()*3))::int
FROM pizza_order o
CROSS JOIN LATERAL (
SELECT id, price
FROM pizza
ORDER BY random()
LIMIT 2
) p;

-- ============================================
-- UPDATE ORDER TOTALS
-- ============================================
UPDATE pizza_order o
SET total = sub.total
FROM (
SELECT
id_order,
SUM(price * quantity) total
FROM order_item
GROUP BY id_order
) sub
WHERE sub.id_order = o.id;

COMMIT;

-- ============================================
-- SAMPLE JSON PAYLOAD
-- ============================================
-- {
--   "name": "Mediterranean Veggie",
--   "description": "Tomato sauce, mozzarella, olives, cherry tomatoes, and oregano",
--   "price": 28.50,
--   "available": true,
--   "type": "VEGETARIAN"
-- }

