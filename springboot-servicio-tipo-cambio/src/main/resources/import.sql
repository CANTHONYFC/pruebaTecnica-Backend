INSERT INTO tipo_cambio (nombre_origen,nombre_destino,moneda_origen,moneda_destino, precio, create_at,create_user)VALUES('Soles','Dolares','PEN','USD',0.27,NOW(),1);
-- Dólar estadounidense (USD) a Euro (EUR)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Dolares', 'Euros', 'USD', 'EUR', 2, NOW(), 1);

-- Dólar estadounidense (USD) a Libra esterlina (GBP)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Dolares', 'Libras Esterlinas', 'USD', 'GBP', 5.5, NOW(), 1);

-- Euro (EUR) a Dólar estadounidense (USD)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Euros', 'Dolares', 'EUR', 'USD',2.3, NOW(), 1);

-- Libra esterlina (GBP) a Dólar estadounidense (USD)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Libras Esterlinas', 'Dolares', 'GBP', 'USD',3.3, NOW(), 1);

-- Dólar australiano (AUD) a Dólar estadounidense (USD)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Dolares Australianos', 'Dolares', 'AUD', 'USD', 4.5, NOW(), 1);

-- Dólar estadounidense (USD) a Dólar australiano (AUD)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Dolares', 'Dolares Australianos', 'USD', 'AUD', 0.34, NOW(), 1);

-- Dólar canadiense (CAD) a Dólar estadounidense (USD)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Dolares Canadienses', 'Dolares', 'CAD', 'USD', 0.44, NOW(), 1);

-- Dólar estadounidense (USD) a Dólar canadiense (CAD)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Dolares', 'Dolares Canadienses', 'USD', 'CAD',0.80, NOW(), 1);

-- Franco suizo (CHF) a Dólar estadounidense (USD)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Francos Suizos', 'Dolares', 'CHF', 'USD', 1, NOW(), 1);

-- Dólar estadounidense (USD) a Franco suizo (CHF)
INSERT INTO tipo_cambio (nombre_origen, nombre_destino, moneda_origen, moneda_destino, precio, create_at, create_user) VALUES ('Dolares', 'Francos Suizos', 'USD', 'CHF', 1, NOW(), 1);
-- Soles a Soles
INSERT INTO tipo_cambio (nombre_origen,nombre_destino,moneda_origen,moneda_destino, precio, create_at,create_user)VALUES('Soles','Soles','PEN','PEN',1,NOW(),1);