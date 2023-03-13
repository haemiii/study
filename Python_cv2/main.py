import cv2
import numpy as np

# OMR 카드 이미지 로드
img = cv2.imread('answer.png')

# 이미지를 grayscale로 변환
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# 이미지 이진화 (adaptive thresholding)
thresh = cv2.adaptiveThreshold(gray, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY_INV, 11, 2)

# contour 추출 (선택지 영역 찾기)
contours, hierarchy = cv2.findContours(thresh, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
# 각 선택지 영역에 대한 좌표 추출
boxes = []
for cnt in contours:
    area = cv2.contourArea(cnt)
    if area > 100:
        x,y,w,h = cv2.boundingRect(cnt)
        boxes.append((x,y,w,h))
boxes.reverse()
# 각 선택지 영역에 대한 좌표를 기반으로 표시된 답의 수 계산
results = []
for i in range(len(boxes)):
    x,y,w,h = boxes[i]
    roi = gray[y+1:y+h, x+2:x+w]
    total_pixels = roi.shape[0] * roi.shape[1]
    black_pixels = total_pixels - cv2.countNonZero(roi)
    if black_pixels > total_pixels/2:
        results.append(i+1)

# 결과 출력
print("표시된 답: ", results)
