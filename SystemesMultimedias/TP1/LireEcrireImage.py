import cv2


im = cv2.imread('3x2.png')
cv2.imshow("Frame", im)

#im[1][1] = [0, 255, 255]
print(im)

cv2.waitKey(0)
cv2.destroyAllWindows()

# Sauvegarde du résultat.
cv2.imwrite('resultat.png', im)
